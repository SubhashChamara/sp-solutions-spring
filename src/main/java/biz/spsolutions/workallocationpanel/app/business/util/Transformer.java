package biz.spsolutions.workallocationpanel.app.business.util;

import biz.spsolutions.workallocationpanel.app.dto.*;
import biz.spsolutions.workallocationpanel.app.entity.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Transformer {
    private final ModelMapper modelMapper =new ModelMapper();

    public WorkTaskDTO fromEntity(WorkTask workTask) {
        return modelMapper.map(workTask, WorkTaskDTO.class);
    }

    public WorkTask toEntity(WorkTaskRequestDTO workTaskRequestDTO) {
        return modelMapper.map(workTaskRequestDTO, WorkTask.class);
    }

    public ClientDTO fromEntity(Client client) {
        return modelMapper.map(client, ClientDTO.class);
    }

    public Client toEntity(ClientDTO clientDTO) {
        return modelMapper.map(clientDTO, Client.class);
    }

    public ProjectDTO fromEntity(Project project) {
        return modelMapper.map(project, ProjectDTO.class);
    }

    public Project toEntity(ProjectDTO projectDTO) {
        return modelMapper.map(projectDTO, Project.class);
    }
    public JobTypeDTO fromEntity(JobType jobType) {
        return modelMapper.map(jobType, JobTypeDTO.class);
    }
    public JobType toEntity(JobTypeDTO jobTypeDTO) {
        return modelMapper.map(jobTypeDTO, JobType.class);
    }

    public DeveloperDTO fromEntity(Developer developer) {
        return modelMapper.map(developer, DeveloperDTO.class);
    }
    public Developer toEntity(DeveloperDTO developerDTO) {
        return modelMapper.map(developerDTO, Developer.class);
    }




}
