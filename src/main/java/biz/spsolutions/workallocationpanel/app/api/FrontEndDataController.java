package biz.spsolutions.workallocationpanel.app.api;

import biz.spsolutions.workallocationpanel.app.business.FrontEndDataBO;
import biz.spsolutions.workallocationpanel.app.dto.ClientDTO;
import biz.spsolutions.workallocationpanel.app.dto.DeveloperDTO;
import biz.spsolutions.workallocationpanel.app.dto.JobTypeDTO;
import biz.spsolutions.workallocationpanel.app.dto.ProjectDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/data")
@Validated
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
    public List<ProjectDTO> getClientList(
            @Validated @NotNull @Positive(message = "ClientId must be a positive number")
            @RequestParam("clientId") int clientId) throws Exception {
        return frontEndDataBO.getProjectListByClient(clientId);
    }

    @GetMapping("/jobTypeList")
    public List<JobTypeDTO> getJobTypeList(
            @Validated @NotNull @Positive(message = "ClientId must be a positive number")
            @RequestParam("projectId")int projectId) throws Exception {
        return frontEndDataBO.getJobTypesByProjectID(projectId);
    }

    @GetMapping("/developerList")
    public List<DeveloperDTO> getDeveloperList() throws Exception {
        return frontEndDataBO.getDeveloperList();
    }
}
