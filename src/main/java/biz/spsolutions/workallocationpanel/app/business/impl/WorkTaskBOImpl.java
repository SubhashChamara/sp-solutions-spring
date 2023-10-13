package biz.spsolutions.workallocationpanel.app.business.impl;

import biz.spsolutions.workallocationpanel.app.business.WorkTaskBO;
import biz.spsolutions.workallocationpanel.app.business.util.Transformer;
import biz.spsolutions.workallocationpanel.app.dao.ActIdMembershipDAO;
import biz.spsolutions.workallocationpanel.app.dao.WorkTaskDAO;
import biz.spsolutions.workallocationpanel.app.dto.WorkTaskDTO;
import biz.spsolutions.workallocationpanel.app.entity.WorkTask;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkTaskBOImpl implements WorkTaskBO {
    private final WorkTaskDAO workTaskDAO;
    private final Transformer transformer;

    private final ActIdMembershipDAO actIdMembershipDAO;
    private final int pageSize;

    public WorkTaskBOImpl(WorkTaskDAO workTaskDAO, Transformer transformer, ActIdMembershipDAO actIdMembershipDAO) {
        this.workTaskDAO = workTaskDAO;
        this.transformer = transformer;
        this.actIdMembershipDAO = actIdMembershipDAO;
        this.pageSize = 5;

    }

    @Override
    public Page<WorkTaskDTO> getAllWorkTasks(Pageable pageable, WorkTaskDTO workTaskDTO) throws Exception {
        System.out.println(workTaskDTO.getClientId());
//        int offset = (pageNumber - 1) * this.pageSize;
        System.out.println();
        Integer counter = actIdMembershipDAO.getUserGroupId(workTaskDTO.getClientUserId());
        System.out.println(workTaskDTO.getClientUserId()+" Client Count "+counter);
        workTaskDTO.setClientUserId(counter>0? workTaskDTO.getClientUserId():null);
        List<WorkTask> workTaskPage = workTaskDAO.getAll(pageable, workTaskDTO.getWfRef(), workTaskDTO.getStartDate(), workTaskDTO.getEndDate(), workTaskDTO.getClientId(), workTaskDTO.getProjectId(), workTaskDTO.getTaskOverallStatus(), workTaskDTO.getDeveloper(), workTaskDTO.getWorkType(), workTaskDTO.getChargeStatus(), workTaskDTO.getJobTypeId(), workTaskDTO.getUserId(), workTaskDTO.getPendingUser(),workTaskDTO.getClientUserId());

        System.out.println(workTaskPage);
        List<WorkTaskDTO> worktaskDTOList = workTaskPage.stream().map(transformer::fromEntity).collect(Collectors.toList());
        Long totalCount = workTaskDAO.getTotalCount(workTaskDTO.getWfRef(), workTaskDTO.getStartDate(), workTaskDTO.getEndDate(), workTaskDTO.getClientId(), workTaskDTO.getProjectId(), workTaskDTO.getTaskOverallStatus(), workTaskDTO.getDeveloper(), workTaskDTO.getWorkType(), workTaskDTO.getChargeStatus(), workTaskDTO.getJobTypeId(), workTaskDTO.getUserId(), workTaskDTO.getPendingUser());
        return new PageImpl<>(worktaskDTOList, pageable, totalCount);

    }

    @Override
    public void updateWorkTaskByWfRef(String wfRef,WorkTaskDTO workTaskDTO) throws Exception {
        workTaskDAO.updateWorkTask(wfRef,workTaskDTO.getJobType(),workTaskDTO.getTaskName(), workTaskDTO.getChargeStatus(), workTaskDTO.getAllocatedTime(),workTaskDTO.getSubmissionDate(), workTaskDTO.getWorkType(), workTaskDTO.getBugFixType(), workTaskDTO.getWorkDescription() , workTaskDTO.getTaskType(), workTaskDTO.getWorkPriority());
    }
}
