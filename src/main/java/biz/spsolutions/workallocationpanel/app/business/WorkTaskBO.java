package biz.spsolutions.workallocationpanel.app.business;

import biz.spsolutions.workallocationpanel.app.business.util.Transformer;
import biz.spsolutions.workallocationpanel.app.dao.WorkTaskDAO;
import biz.spsolutions.workallocationpanel.app.dto.WorkTaskDTO;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkTaskBO {
    private final WorkTaskDAO workTaskDAO;
    private final Transformer transformer;

    public WorkTaskBO(WorkTaskDAO workTaskDAO, Transformer transformer) {
        this.workTaskDAO = workTaskDAO;
        this.transformer = transformer;
    }


    public List<WorkTaskDTO> getAllWorkTasks(WorkTaskDTO workTaskDTO) throws Exception {
        System.out.println(workTaskDTO);
        return workTaskDAO.getAll(workTaskDTO.getWfRef(),workTaskDTO.getStartDate(),workTaskDTO.getEndDate(),workTaskDTO.getClientId(),workTaskDTO.getProjectId(),workTaskDTO.getTaskOverallStatus(),workTaskDTO.getDeveloperId(),workTaskDTO.getWorkType(),workTaskDTO.getChargeStatus(),workTaskDTO.getJobTypeId(),workTaskDTO.getUserId(),workTaskDTO.getPendingUser()).stream().map(transformer::fromEntity).collect(Collectors.toList());
    }
}
