package biz.spsolutions.workallocationpanel.app.business.impl;

import biz.spsolutions.workallocationpanel.app.business.WorkTaskBO;
import biz.spsolutions.workallocationpanel.app.business.util.ExcelGenerator;
import biz.spsolutions.workallocationpanel.app.business.util.Transformer;
import biz.spsolutions.workallocationpanel.app.dto.WorkTaskRequestDTO;
import biz.spsolutions.workallocationpanel.app.entity.WorkTaskCounter;
import biz.spsolutions.workallocationpanel.app.mapper.ActIdMembershipMapper;
import biz.spsolutions.workallocationpanel.app.mapper.WorkTaskMapper;
import biz.spsolutions.workallocationpanel.app.dto.WorkTaskDTO;
import biz.spsolutions.workallocationpanel.app.entity.WorkTask;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkTaskBOImpl implements WorkTaskBO {
    private final WorkTaskMapper workTaskMapper;
    private final ActIdMembershipMapper actIdMembershipMapper;
    private final Transformer transformer;
    private final ExcelGenerator excelGenerator;
    private final int pageSize;

    public WorkTaskBOImpl(WorkTaskMapper workTaskMapper, ActIdMembershipMapper actIdMembershipMapper, Transformer transformer, ExcelGenerator excelGenerator) {

        this.workTaskMapper = workTaskMapper;
        this.actIdMembershipMapper = actIdMembershipMapper;
        this.transformer = transformer;
        this.excelGenerator = excelGenerator;
        this.pageSize = 5;
    }

    @Override
    public Page<WorkTaskDTO> getAllWorkTasks(Pageable pageable, WorkTaskRequestDTO workTaskRequestDTO) throws Exception {

        Integer counter = actIdMembershipMapper.getUserGroupId(workTaskRequestDTO.getLoggedUser());
        workTaskRequestDTO.setLoggedUser(counter>0? workTaskRequestDTO.getLoggedUser():null);

        List<WorkTask> workTaskPage = workTaskMapper.getAll(pageable, workTaskRequestDTO.getWfRef(), workTaskRequestDTO.getStartDate(), workTaskRequestDTO.getEndDate(), workTaskRequestDTO.getClientId(), workTaskRequestDTO.getProjectId(), workTaskRequestDTO.getTaskOverallStatus(), workTaskRequestDTO.getDeveloper(), workTaskRequestDTO.getWorkType(), workTaskRequestDTO.getChargeStatus(), workTaskRequestDTO.getJobTypeId(),workTaskRequestDTO.getPendingUser(),workTaskRequestDTO.getLoggedUser());
        List<WorkTaskDTO> worktaskDTOList = workTaskPage.stream().map(transformer::fromEntity).collect(Collectors.toList());
        Long totalCount = workTaskMapper.getTotalCounts();
        return new PageImpl<>(worktaskDTOList, pageable, totalCount);

    }

    @Override
    public WorkTaskCounter getWorkTasksCountList(WorkTaskRequestDTO workTaskRequestDTO) throws Exception {

        Integer counter = actIdMembershipMapper.getUserGroupId(workTaskRequestDTO.getLoggedUser());
        workTaskRequestDTO.setLoggedUser(counter>0? workTaskRequestDTO.getLoggedUser():null);
        Date today = new Date();
        System.out.println(today);
        WorkTaskCounter counts = workTaskMapper.getCounts(workTaskRequestDTO.getWfRef(), workTaskRequestDTO.getStartDate(), workTaskRequestDTO.getEndDate(), workTaskRequestDTO.getClientId(), workTaskRequestDTO.getProjectId(), workTaskRequestDTO.getTaskOverallStatus(), workTaskRequestDTO.getDeveloper(), workTaskRequestDTO.getWorkType(), workTaskRequestDTO.getChargeStatus(), workTaskRequestDTO.getJobTypeId(), workTaskRequestDTO.getPendingUser(), workTaskRequestDTO.getLoggedUser(),today);
        Long totalCount =counts.getTotalCount();
        Long lateCount =counts.getLateCount();

        counts.setWithinDueDatePercentage(Math.round(((totalCount - lateCount) / (double) totalCount) * 10000.0) / 100.0);
        counts.setLatePercentage(Math.round((lateCount / (double) totalCount) * 10000.0) / 100.0);
        return  counts;

    }

    @Override
    public ByteArrayInputStream getWorkTaskListExcel(Pageable pageable, WorkTaskRequestDTO workTaskRequestDTO) throws Exception {
        Integer counter = actIdMembershipMapper.getUserGroupId(workTaskRequestDTO.getLoggedUser());
        workTaskRequestDTO.setLoggedUser(counter>0? workTaskRequestDTO.getLoggedUser():null);
        List<WorkTask> workTaskPage = workTaskMapper.getAll(pageable, workTaskRequestDTO.getWfRef(), workTaskRequestDTO.getStartDate(), workTaskRequestDTO.getEndDate(), workTaskRequestDTO.getClientId(), workTaskRequestDTO.getProjectId(), workTaskRequestDTO.getTaskOverallStatus(), workTaskRequestDTO.getDeveloper(), workTaskRequestDTO.getWorkType(), workTaskRequestDTO.getChargeStatus(), workTaskRequestDTO.getJobTypeId(),workTaskRequestDTO.getPendingUser(),workTaskRequestDTO.getLoggedUser());
        List<WorkTaskDTO> worktaskDTOList = workTaskPage.stream().map(transformer::fromEntity).collect(Collectors.toList());

        ByteArrayInputStream byteArrayInputStream = excelGenerator.dateToExcel(worktaskDTOList);
        return byteArrayInputStream;

    }


    @Override
    public void updateWorkTaskByWfRef(String wfRef,WorkTaskRequestDTO workTaskDTO) throws Exception {
//        workTaskDAO.updateWorkTask(wfRef,workTaskDTO.getJobType(),workTaskDTO.getTaskName(), workTaskDTO.getChargeStatus(), workTaskDTO.getAllocatedTime(),workTaskDTO.getSubmissionDate(), workTaskDTO.getWorkType(), workTaskDTO.getBugFixType(), workTaskDTO.getWorkDescription() , workTaskDTO.getTaskType(), workTaskDTO.getWorkPriority());

    }
}
