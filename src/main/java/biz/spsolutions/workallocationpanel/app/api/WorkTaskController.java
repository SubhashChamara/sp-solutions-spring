package biz.spsolutions.workallocationpanel.app.api;

import biz.spsolutions.workallocationpanel.app.dto.WorkTaskDTO;
import biz.spsolutions.workallocationpanel.app.business.WorkTaskBO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
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
    public List<WorkTaskDTO> getAllTasks(@RequestBody WorkTaskDTO workTaskDTO) throws Exception {
        System.out.println(workTaskDTO);
        return workTaskBO.getAllWorkTasks(workTaskDTO);
    }

}
