package biz.spsolutions.workallocationpanel.app.api;

import biz.spsolutions.workallocationpanel.app.business.WorkTaskBO;
import biz.spsolutions.workallocationpanel.app.dto.WorkTaskRequestDTO;
import biz.spsolutions.workallocationpanel.app.dto.WorkTaskDTO;
import biz.spsolutions.workallocationpanel.app.entity.WorkTaskCounter;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("api/v1/work-tasks")
@CrossOrigin
@Validated
public class WorkTaskController {
    private final WorkTaskBO workTaskBO;

    public WorkTaskController(WorkTaskBO workTaskBO) {
        this.workTaskBO = workTaskBO;
    }

    @GetMapping(path = "/work-task-list")
    public ResponseEntity<Page<WorkTaskDTO>> getAllTasks(
            @Validated @NotNull @Pattern(regexp = "^(\\d+|ALL)$", message = "wfRef must be a number or 'ALL'")
            @RequestParam("wfRef") String wfRef,

            @Valid @NotNull @Pattern(regexp = "^(\\d{4}-\\d{2}-\\d{2}|ALL)$", message = "Invalid date format. Use 'yyyy:MM:dd' or 'ALL'")
            @RequestParam("startDate") String startDateString,

            @Valid @NotNull @Pattern(regexp = "^(\\d{4}-\\d{2}-\\d{2}|ALL)$", message = "Invalid date format. Use 'yyyy:MM:dd' or 'ALL'")
            @RequestParam("endDate") String endDateString,

            @Validated @NotNull @Pattern(regexp = "^(\\d+|ALL)$", message = "Client Id must be a number or 'ALL'")
            @RequestParam("clientId") String client,

            @Validated @NotNull @Pattern(regexp = "^(\\d+|ALL)$", message = "Project Id must be a number or 'ALL'")
            @RequestParam("projectId") String project,

            @Validated @NotNull @Pattern(regexp = "^(\\d+|ALL)$", message = "Job Type must be a number or 'ALL'")
            @RequestParam("jobType") String jobType,

            @Valid @NotNull @Pattern(regexp = "^(Bug Fix|New Requirement|Change Logic|Change Requirement|Complaint|System Implementation|System Design|ALL)$", message = "Invalid WorkType")
            @RequestParam("workType") String workType,

            @Valid @NotNull @Pattern(regexp = "^(Maintainance|Charged|FOC|ALL)$", message = "Invalid ChargeType")
            @RequestParam("chargeType") String chargeType,

            @Valid @NotNull @Pattern(regexp = "^(ONGOING|HOLD|COMPLETED|DEV\\.COMPLETED|DEV\\.RETURN|QA\\.COMPLETED|QA\\.PENDING|NEW|WITH DH|RELEASED|ALL)$", message = "Invalid overallStatus")
            @RequestParam("overallStatus") String status,

            @Valid @NotNull @Pattern(regexp = "^([A-Za-z_]+|ALL)$",message = "Invalid PendingUser Name")
            @RequestParam("pendingUser") String pendingUser,

            @Valid @NotNull @Pattern(regexp = "^([A-Za-z_]+|ALL)$",message = "Invalid Developer Name")
            @RequestParam("developer") String developer,

            @Validated @NotNull @Pattern(regexp = "^(\\d+)$", message = "Page Number must be a positive number or 0")
            @RequestParam("page") String pageNumber,

            @Validated @NotNull @Pattern(regexp = "^[1-9]\\d*$", message = "Page Size must be a number greater than 0")
            @RequestParam("size") String pageSize,

            @Valid @NotNull @Pattern(regexp = "^[A-Za-z_]+$",message = "Invalid Logged User")
            @RequestParam("loggedUserId") String loggedUserId
    ) throws Exception {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date startDate;
//        Date endDate;
//
//         Date startDate = startDateString!=null? dateFormat.parse(startDateString):null;
//         Date endDate = endDateString !=null? dateFormat.parse(endDateString):null;
//

        WorkTaskRequestDTO workTaskRequestDTO = new WorkTaskRequestDTO();

        workTaskRequestDTO.setWfRef(wfRef.equals("ALL") ? null : wfRef);
        workTaskRequestDTO.setStartDate(!startDateString.equals("ALL")? dateFormat.parse(startDateString):null);
        workTaskRequestDTO.setEndDate(!endDateString.equals("ALL")? dateFormat.parse(endDateString):null);
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
        return ResponseEntity.ok(workTaskBO.getAllWorkTasks(pageable,workTaskRequestDTO));
    }


    @GetMapping(path = "/work-task-count-list")
    public WorkTaskCounter getAllTaskCount(
            @Validated @NotNull @Pattern(regexp = "^(\\d+|ALL)$", message = "wfRef must be a number or 'ALL'")
            @RequestParam("wfRef") String wfRef,

            @Valid @NotNull @Pattern(regexp = "^(\\d{4}-\\d{2}-\\d{2}|ALL)$", message = "Invalid date format. Use 'yyyy:MM:dd' or 'ALL'")
            @RequestParam("startDate") String startDateString,

            @Valid @NotNull @Pattern(regexp = "^(\\d{4}-\\d{2}-\\d{2}|ALL)$", message = "Invalid date format. Use 'yyyy:MM:dd' or 'ALL'")
            @RequestParam("endDate") String endDateString,

            @Validated @NotNull @Pattern(regexp = "^(\\d+|ALL)$", message = "Client Id must be a number or 'ALL'")
            @RequestParam("clientId") String client,

            @Validated @NotNull @Pattern(regexp = "^(\\d+|ALL)$", message = "Project Id must be a number or 'ALL'")
            @RequestParam("projectId") String project,

            @Validated @NotNull @Pattern(regexp = "^(\\d+|ALL)$", message = "Job Type must be a number or 'ALL'")
            @RequestParam("jobType") String jobType,

            @Valid @NotNull @Pattern(regexp = "^(Bug Fix|New Requirement|Change Logic|Change Requirement|Complaint|System Implementation|System Design|ALL)$", message = "Invalid WorkType")
            @RequestParam("workType") String workType,

            @Valid @NotNull @Pattern(regexp = "^(Maintainance|Charged|FOC|ALL)$", message = "Invalid ChargeType")
            @RequestParam("chargeType") String chargeType,

            @Valid @NotNull @Pattern(regexp = "^(ONGOING|HOLD|COMPLETED|DEV\\.COMPLETED|DEV\\.RETURN|QA\\.COMPLETED|QA\\.PENDING|NEW|WITH DH|RELEASED|ALL)$", message = "Invalid overallStatus")
            @RequestParam("overallStatus") String status,

            @Valid @NotNull @Pattern(regexp = "^([A-Za-z_]+|ALL)$",message = "Invalid PendingUser Name")
            @RequestParam("pendingUser") String pendingUser,

            @Valid @NotNull @Pattern(regexp = "^([A-Za-z_]+|ALL)$",message = "Invalid Developer Name")
            @RequestParam("developer") String developer,

            @Valid @NotNull @Pattern(regexp = "^[A-Za-z_]+$",message = "Invalid Logged User")
            @RequestParam("loggedUserId") String loggedUserId
    ) throws Exception {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date startDate;
//        Date endDate;
//        try {
//            startDate = dateFormat.parse(startDateString);
//            endDate = dateFormat.parse(endDateString);
//        } catch (Exception e) {
////            e.printStackTrace();
//            startDate = null;
//            endDate = null;
//        }

        WorkTaskRequestDTO workTaskRequestDTO = new WorkTaskRequestDTO();

        workTaskRequestDTO.setWfRef(wfRef.equals("ALL") ? null : wfRef);
        workTaskRequestDTO.setStartDate(!startDateString.equals("ALL")? dateFormat.parse(startDateString):null);
        workTaskRequestDTO.setEndDate(!endDateString.equals("ALL")? dateFormat.parse(endDateString):null);
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
            @Validated @NotNull @Pattern(regexp = "^(\\d+|ALL)$", message = "wfRef must be a number or 'ALL'")
            @RequestParam("wfRef") String wfRef,

            @Valid @NotNull @Pattern(regexp = "^(\\d{4}-\\d{2}-\\d{2}|ALL)$", message = "Invalid date format. Use 'yyyy:MM:dd' or 'ALL'")
            @RequestParam("startDate") String startDateString,

            @Valid @NotNull @Pattern(regexp = "^(\\d{4}-\\d{2}-\\d{2}|ALL)$", message = "Invalid date format. Use 'yyyy:MM:dd' or 'ALL'")
            @RequestParam("endDate") String endDateString,

            @Validated @NotNull @Pattern(regexp = "^(\\d+|ALL)$", message = "Client Id must be a number or 'ALL'")
            @RequestParam("clientId") String client,

            @Validated @NotNull @Pattern(regexp = "^(\\d+|ALL)$", message = "Project Id must be a number or 'ALL'")
            @RequestParam("projectId") String project,

            @Validated @NotNull @Pattern(regexp = "^(\\d+|ALL)$", message = "Job Type must be a number or 'ALL'")
            @RequestParam("jobType") String jobType,

            @Valid @NotNull @Pattern(regexp = "^(Bug Fix|New Requirement|Change Logic|Change Requirement|Complaint|System Implementation|System Design|ALL)$", message = "Invalid WorkType")
            @RequestParam("workType") String workType,

            @Valid @NotNull @Pattern(regexp = "^(Maintainance|Charged|FOC|ALL)$", message = "Invalid ChargeType")
            @RequestParam("chargeType") String chargeType,

            @Valid @NotNull @Pattern(regexp = "^(ONGOING|HOLD|COMPLETED|DEV\\.COMPLETED|DEV\\.RETURN|QA\\.COMPLETED|QA\\.PENDING|NEW|WITH DH|RELEASED|ALL)$", message = "Invalid overallStatus")
            @RequestParam("overallStatus") String status,

            @Valid @NotNull @Pattern(regexp = "^([A-Za-z_]+|ALL)$",message = "Invalid PendingUser Name")
            @RequestParam("pendingUser") String pendingUser,

            @Valid @NotNull @Pattern(regexp = "^([A-Za-z_]+|ALL)$",message = "Invalid Developer Name")
            @RequestParam("developer") String developer,

            @Valid @NotNull @Pattern(regexp = "^[A-Za-z_]+$",message = "Invalid Logged User")
            @RequestParam("loggedUserId") String loggedUserId
    ) throws Exception {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date startDate;
//        Date endDate;
//        try {
//            startDate = dateFormat.parse(startDateString);
//            endDate = dateFormat.parse(endDateString);
//        } catch (Exception e) {
////            e.printStackTrace();
//            startDate = null;
//            endDate = null;
//        }

        WorkTaskRequestDTO workTaskRequestDTO = new WorkTaskRequestDTO();

        workTaskRequestDTO.setWfRef(wfRef.equals("ALL") ? null : wfRef);
        workTaskRequestDTO.setStartDate(!startDateString.equals("ALL")? dateFormat.parse(startDateString):null);
        workTaskRequestDTO.setEndDate(!endDateString.equals("ALL")? dateFormat.parse(endDateString):null);
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
