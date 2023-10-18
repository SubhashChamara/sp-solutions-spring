package biz.spsolutions.workallocationpanel.app.api;

import biz.spsolutions.workallocationpanel.app.business.WorkTaskBO;
import biz.spsolutions.workallocationpanel.app.dto.WorkTaskRequestDTO;
import biz.spsolutions.workallocationpanel.app.dto.WorkTaskDTO;
import biz.spsolutions.workallocationpanel.app.entity.WorkTaskCounter;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("api/v1/work-tasks")
@CrossOrigin
public class WorkTaskController {
    private final WorkTaskBO workTaskBO;

    public WorkTaskController(WorkTaskBO workTaskBO) {
        this.workTaskBO = workTaskBO;
    }

    @GetMapping(path = "/work-task-list")
    public Page<WorkTaskDTO> getAllTasks(
            @RequestParam("wfRef") String wfRef,
            @RequestParam("startDate") String startDateString,
            @RequestParam("endDate") String endDateString,
            @RequestParam("clientId") String client,
            @RequestParam("projectId") String project,
            @RequestParam("jobType") String jobType,
            @RequestParam("workType") String workType,
            @RequestParam("chargeType") String chargeType,
            @RequestParam("overallStatus") String status,
            @RequestParam("pendingUser") String pendingUser,
            @RequestParam("developer") String developer,
            @RequestParam("page") String pageNumber,
            @RequestParam("size") String pageSize,
            @RequestParam("loggedUserId") String loggedUserId
    ) throws Exception {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate;
        Date endDate;
        try {
            startDate = dateFormat.parse(startDateString);
            endDate = dateFormat.parse(endDateString);
        } catch (Exception e) {
//            e.printStackTrace();
            startDate = null;
            endDate = null;
        }

        WorkTaskRequestDTO workTaskRequestDTO = new WorkTaskRequestDTO();

        workTaskRequestDTO.setWfRef(wfRef.equals("ALL") ? null : wfRef);
        workTaskRequestDTO.setStartDate(startDate);
        workTaskRequestDTO.setEndDate(endDate);
        workTaskRequestDTO.setClientId(client.equals("ALL") ? null : Integer.valueOf(client));
        workTaskRequestDTO.setProjectId(project.equals("ALL") ? null : Integer.valueOf(project));
        workTaskRequestDTO.setJobTypeId(jobType.equals("ALL") ? null : new BigInteger(jobType));
        workTaskRequestDTO.setWorkType(workType.equals("ALL") ? null : workType);
        workTaskRequestDTO.setChargeStatus(chargeType.equals("ALL") ? null : chargeType);
        workTaskRequestDTO.setTaskOverallStatus(status.equals("ALL") ? null : status);
        workTaskRequestDTO.setPendingUser(pendingUser.equals("ALL") ? null : pendingUser);
        workTaskRequestDTO.setDeveloper(developer.equals("ALL") ? null : developer);
        workTaskRequestDTO.setLoggedUser(loggedUserId);
//        System.out.println(workTaskDTO);

        Pageable pageable = PageRequest.of(Integer.parseInt(pageNumber), Integer.parseInt(pageSize));
        return workTaskBO.getAllWorkTasks(pageable, workTaskRequestDTO);
    }


    @GetMapping(path = "/work-task-count-list")
    public WorkTaskCounter getAllTaskCount(
            @RequestParam("wfRef") String wfRef,
            @RequestParam("startDate") String startDateString,
            @RequestParam("endDate") String endDateString,
            @RequestParam("clientId") String client,
            @RequestParam("projectId") String project,
            @RequestParam("jobType") String jobType,
            @RequestParam("workType") String workType,
            @RequestParam("chargeType") String chargeType,
            @RequestParam("overallStatus") String status,
            @RequestParam("pendingUser") String pendingUser,
            @RequestParam("developer") String developer,
            @RequestParam("loggedUserId") String loggedUserId
    ) throws Exception {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate;
        Date endDate;
        try {
            startDate = dateFormat.parse(startDateString);
            endDate = dateFormat.parse(endDateString);
        } catch (Exception e) {
//            e.printStackTrace();
            startDate = null;
            endDate = null;
        }

        WorkTaskRequestDTO workTaskRequestDTO = new WorkTaskRequestDTO();

        workTaskRequestDTO.setWfRef(wfRef.equals("ALL") ? null : wfRef);
        workTaskRequestDTO.setStartDate(startDate);
        workTaskRequestDTO.setEndDate(endDate);
        workTaskRequestDTO.setClientId(client.equals("ALL") ? null : Integer.valueOf(client));
        workTaskRequestDTO.setProjectId(project.equals("ALL") ? null : Integer.valueOf(project));
        workTaskRequestDTO.setJobTypeId(jobType.equals("ALL") ? null : new BigInteger(jobType));
        workTaskRequestDTO.setWorkType(workType.equals("ALL") ? null : workType);
        workTaskRequestDTO.setChargeStatus(chargeType.equals("ALL") ? null : chargeType);
        workTaskRequestDTO.setTaskOverallStatus(status.equals("ALL") ? null : status);
        workTaskRequestDTO.setPendingUser(pendingUser.equals("ALL") ? null : pendingUser);
        workTaskRequestDTO.setDeveloper(developer.equals("ALL") ? null : developer);
        workTaskRequestDTO.setLoggedUser(loggedUserId);
//        System.out.println(workTaskDTO);

//        Pageable pageable = PageRequest.of(Integer.parseInt(pageNumber), Integer.parseInt(pageSize));
        return workTaskBO.getWorkTasksCountList(workTaskRequestDTO);
    }

    @GetMapping(path = "/download-excel")
    public ResponseEntity<Resource> downloadWorkTaskExcel(
            @RequestParam("wfRef") String wfRef,
            @RequestParam("startDate") String startDateString,
            @RequestParam("endDate") String endDateString,
            @RequestParam("clientId") String client,
            @RequestParam("projectId") String project,
            @RequestParam("jobType") String jobType,
            @RequestParam("workType") String workType,
            @RequestParam("chargeType") String chargeType,
            @RequestParam("overallStatus") String status,
            @RequestParam("pendingUser") String pendingUser,
            @RequestParam("developer") String developer,
            @RequestParam("loggedUserId") String loggedUserId
    ) throws Exception {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate;
        Date endDate;
        try {
            startDate = dateFormat.parse(startDateString);
            endDate = dateFormat.parse(endDateString);
        } catch (Exception e) {
//            e.printStackTrace();
            startDate = null;
            endDate = null;
        }

        WorkTaskRequestDTO workTaskRequestDTO = new WorkTaskRequestDTO();

        workTaskRequestDTO.setWfRef(wfRef.equals("ALL") ? null : wfRef);
        workTaskRequestDTO.setStartDate(startDate);
        workTaskRequestDTO.setEndDate(endDate);
        workTaskRequestDTO.setClientId(client.equals("ALL") ? null : Integer.valueOf(client));
        workTaskRequestDTO.setProjectId(project.equals("ALL") ? null : Integer.valueOf(project));
        workTaskRequestDTO.setJobTypeId(jobType.equals("ALL") ? null : new BigInteger(jobType));
        workTaskRequestDTO.setWorkType(workType.equals("ALL") ? null : workType);
        workTaskRequestDTO.setChargeStatus(chargeType.equals("ALL") ? null : chargeType);
        workTaskRequestDTO.setTaskOverallStatus(status.equals("ALL") ? null : status);
        workTaskRequestDTO.setPendingUser(pendingUser.equals("ALL") ? null : pendingUser);
        workTaskRequestDTO.setDeveloper(developer.equals("ALL") ? null : developer);
        workTaskRequestDTO.setLoggedUser(loggedUserId);
//        System.out.println(workTaskDTO);

//        Pageable pageable = PageRequest.of(Integer.parseInt("0"), Integer.parseInt("0"));
        ByteArrayInputStream workTaskListExcel = workTaskBO.getWorkTaskListExcel(null, workTaskRequestDTO);
        InputStreamResource file = new InputStreamResource(workTaskListExcel);
        String fileName = "worktask.xlsx";
        ResponseEntity<Resource> body = ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachments;filename=" + fileName)
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(file);

        return body;
    }


    @PatchMapping("/{wfRef}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateWorkTask(@PathVariable String wfRef, @RequestBody WorkTaskRequestDTO workTaskDTO) throws Exception {
        System.out.println("update api");
        workTaskBO.updateWorkTaskByWfRef(wfRef, workTaskDTO);

    }

}
