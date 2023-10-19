package biz.spsolutions.workallocationpanel.app.business.util;
import biz.spsolutions.workallocationpanel.app.dto.WorkTaskDTO;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.jsoup.parser.Parser;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class ExcelGenerator {

    public static String[] HEADERS= {
            "WF Ref",
            "Client Name",
            "Project Name",
            "Job Type",
            "Task Name",
            "Work Type",
            "Bug Fix Type",
            "Charge Type",
            "Description",
            "Priority",
            "Allocated Time",
            "Elapsed Time",
            "Dev.Completed Date",
            "Due Date",
            "Status",
            "Acc.Manager",
            "Dev.Manager",
            "Developer"
};
    public static String SHEET_NAME = "Work Task List";

    public ByteArrayInputStream dateToExcel(List<WorkTaskDTO> workTaskDTOList) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy  HH:mm:ss");
        try(Workbook workbook = new XSSFWorkbook();ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet(SHEET_NAME);
            Row row = sheet.createRow(0);
            for (int i = 0; i < HEADERS.length; i++) {
                row.createCell(i).setCellValue(HEADERS[i]);
            }

            int rowNumber = 1;
            for (WorkTaskDTO task:workTaskDTOList) {
                Row dataRow = sheet.createRow(rowNumber);
                rowNumber++;
                dataRow.createCell(0).setCellValue(task.getWfRef()!=null?task.getWfRef():"");
                dataRow.createCell(1).setCellValue(task.getClientName()!=null?task.getClientName():"");
                dataRow.createCell(2).setCellValue(task.getProjectName()!=null?task.getProjectName():"");
                dataRow.createCell(3).setCellValue(task.getJobType()!=null?task.getJobType():"");
                dataRow.createCell(4).setCellValue(task.getTaskName()!=null?task.getTaskName():"");
                dataRow.createCell(5).setCellValue(task.getWorkType()!=null?task.getWorkType():"");
                dataRow.createCell(6).setCellValue(task.getBugFixType()!=null?task.getBugFixType():"");
                dataRow.createCell(7).setCellValue(task.getChargeStatus()!=null?task.getChargeStatus():"");

                String workDescription = task.getWorkDescription() != null? this.decodeHtml(task.getWorkDescription()):"";
                // Check character count for excel maximum character count(32767)
                if (workDescription.length() <= 32767) {
                    dataRow.createCell(8).setCellValue(workDescription);
                } else {
                    dataRow.createCell(8).setCellValue("Description count is higher than maximum character count for a cell");
                }

                dataRow.createCell(9).setCellValue(task.getWorkPriority()!=null?task.getWorkPriority():"");
                dataRow.createCell(10).setCellValue(task.getAllocatedTime()!=null?task.getAllocatedTime():"");
                dataRow.createCell(11).setCellValue(task.getElapsedTime()!=null?task.getElapsedTime():"");
                dataRow.createCell(12).setCellValue(task.getWorkCompletedDate()!=null?sdf.format(task.getWorkCompletedDate()).toString():"");
                dataRow.createCell(13).setCellValue(task.getSubmissionDate()!=null?sdf.format(task.getSubmissionDate()).toString():"");
                dataRow.createCell(14).setCellValue(task.getTaskOverallStatus()!=null?task.getTaskOverallStatus():"");
                dataRow.createCell(15).setCellValue(task.getAccountManager()!=null?task.getAccountManager():"");
                dataRow.createCell(16).setCellValue(task.getDeveloperManager()!=null?task.getDeveloperManager():"");
                dataRow.createCell(17).setCellValue(task.getDeveloper()!=null?task.getDeveloper():"");


            }
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to load data to the excel file");
            return null;
        }
    }

    private String decodeHtml(String source) {
        String conString = "";
        try {
            boolean strictMode = true;
            conString = Parser.unescapeEntities(source, strictMode);
            conString = conString.replaceAll("\\<br>", "\n");
            conString = conString.replaceAll("\\<br/>", "\n");
            conString = conString.replaceAll("\\<.*?\\>", "");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to decode HTML elements in the work description");
        }
        return conString;
    }

}
