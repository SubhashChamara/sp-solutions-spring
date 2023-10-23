package biz.spsolutions.workallocationpanel.app.business.impl;

import biz.spsolutions.workallocationpanel.app.business.FrontEndDataBO;
import biz.spsolutions.workallocationpanel.app.business.util.Transformer;
import biz.spsolutions.workallocationpanel.app.dto.ClientDTO;
import biz.spsolutions.workallocationpanel.app.dto.DeveloperDTO;
import biz.spsolutions.workallocationpanel.app.dto.JobTypeDTO;
import biz.spsolutions.workallocationpanel.app.dto.ProjectDTO;
import biz.spsolutions.workallocationpanel.app.mapper.DeveloperMapper;
import biz.spsolutions.workallocationpanel.app.mapper.MasterClient;
import biz.spsolutions.workallocationpanel.app.mapper.MasterJobType;
import biz.spsolutions.workallocationpanel.app.mapper.MasterProject;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FrontEndDataBOImpl implements FrontEndDataBO {

    private final MasterClient masterClient;
    private final MasterProject masterProject;
    private final Transformer transformer;
    private final MasterJobType masterJobType;
    private final DeveloperMapper developerMapper;

    public FrontEndDataBOImpl(MasterClient masterClient, MasterProject masterProject, Transformer transformer, MasterJobType masterJobType, DeveloperMapper developerMapper) {
        this.masterClient = masterClient;
        this.masterProject = masterProject;
        this.transformer = transformer;
        this.masterJobType = masterJobType;
        this.developerMapper = developerMapper;
    }

    @Override
    public List<ClientDTO> getClientList() throws Exception {
         return masterClient.getAll().stream().map(transformer::fromEntity).collect(Collectors.toList());
    }

    @Override
    public List<ProjectDTO> getProjectListByClient(int clientId) throws Exception {
        return masterProject.getAllByClient(clientId).stream().map(transformer::fromEntity).collect(Collectors.toList());
    }

    @Override
    public List<JobTypeDTO> getJobTypesByProjectID(int projectId) throws Exception {
        System.out.println(projectId);
        return masterJobType.getAllByProjectId(projectId).stream().map(transformer::fromEntity).collect(Collectors.toList());

    }

    @Override
    public List<DeveloperDTO> getDeveloperList() throws Exception {
        return developerMapper.getAll().stream().map(transformer::fromEntity).collect(Collectors.toList());
    }


}
