package biz.spsolutions.workallocationpanel.app.api;

import biz.spsolutions.workallocationpanel.app.business.WorkTaskBO;
import biz.spsolutions.workallocationpanel.app.dto.WorkTaskDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/worktasks")
public class WorkTaskController {
    private final WorkTaskBO workTaskBO;

    public WorkTaskController(WorkTaskBO workTaskBO) {
        this.workTaskBO = workTaskBO;
    }

    @GetMapping
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
            e.printStackTrace();
            startDate = null;
            endDate = null;
        }

        WorkTaskDTO workTaskDTO = new WorkTaskDTO();

        workTaskDTO.setWfRef(wfRef.equals("ALL")?null:wfRef);
        workTaskDTO.setStartDate(startDate);
        workTaskDTO.setEndDate(endDate);
        workTaskDTO.setClientId(client.equals("ALL")? null: Integer.valueOf(client));
        workTaskDTO.setProjectId(project.equals("ALL")? null: Integer.valueOf(project));
        workTaskDTO.setJobType(jobType.equals("ALL")? null: jobType);
        workTaskDTO.setWorkType(workType.equals("ALL")?null:workType);
        workTaskDTO.setChargeStatus(chargeType.equals("ALL")? null:chargeType);
        workTaskDTO.setTaskOverallStatus(status.equals("ALL")? null:status);
        workTaskDTO.setPendingUser(pendingUser.equals("ALL")? null:pendingUser);
        workTaskDTO.setDeveloper(developer.equals("ALL")?null:developer);
        workTaskDTO.setClientUserId(loggedUserId);
        System.out.println(workTaskDTO);
        int ss = Integer.parseInt(pageSize);
        Pageable pageable = PageRequest.of(Integer.parseInt(pageNumber), Integer.parseInt(pageSize));
        return workTaskBO.getAllWorkTasks(pageable, workTaskDTO);
    }

    @PatchMapping("/{wfRef}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateWorkTask(@PathVariable String wfRef, @RequestBody WorkTaskDTO workTaskDTO) throws Exception {
        System.out.println("update api");
        workTaskBO.updateWorkTaskByWfRef(wfRef, workTaskDTO);

    }

}
