package biz.spsolutions.workallocationpanel.app.api;

import biz.spsolutions.workallocationpanel.app.business.FrontEndDataBO;
import biz.spsolutions.workallocationpanel.app.dto.ClientDTO;
import biz.spsolutions.workallocationpanel.app.dto.DeveloperDTO;
import biz.spsolutions.workallocationpanel.app.dto.JobTypeDTO;
import biz.spsolutions.workallocationpanel.app.dto.ProjectDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/data")
public class FrontEndDataController {

    private final FrontEndDataBO frontEndDataBO;

    public FrontEndDataController(FrontEndDataBO frontEndDataBO) {
        this.frontEndDataBO = frontEndDataBO;
    }

    @GetMapping("/clientList")
    public List<ClientDTO> getClientList() throws Exception {
        return frontEndDataBO.getClientList();
    }

    @GetMapping("/projectList")
    public List<ProjectDTO> getClientList(@RequestParam("clientId")int clientId) throws Exception {
        System.out.println("request to project-list");
        return frontEndDataBO.getProjectListByClient(clientId);
    }

    @GetMapping("/jobTypeList")
    public List<JobTypeDTO> getJobTypeList(@RequestParam("projectId")int projectId) throws Exception {
        System.out.println(frontEndDataBO.getJobTypesByProjectID(projectId));
        return frontEndDataBO.getJobTypesByProjectID(projectId);
    }

    @GetMapping("/developerList")
    public List<DeveloperDTO> getDeveloperList() throws Exception {
        return frontEndDataBO.getDeveloperList();
    }
}
