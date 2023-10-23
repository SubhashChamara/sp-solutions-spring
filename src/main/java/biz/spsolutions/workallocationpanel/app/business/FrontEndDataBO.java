package biz.spsolutions.workallocationpanel.app.business;

import biz.spsolutions.workallocationpanel.app.dto.ClientDTO;
import biz.spsolutions.workallocationpanel.app.dto.DeveloperDTO;
import biz.spsolutions.workallocationpanel.app.dto.JobTypeDTO;
import biz.spsolutions.workallocationpanel.app.dto.ProjectDTO;

import java.util.List;

public interface FrontEndDataBO {

    public List<ClientDTO> getClientList() throws Exception;
    public List<ProjectDTO> getProjectListByClient(int ClientId) throws Exception;
    public List<JobTypeDTO> getJobTypesByProjectID(int projectId) throws Exception;
    public List<DeveloperDTO> getDeveloperList() throws Exception;
}
