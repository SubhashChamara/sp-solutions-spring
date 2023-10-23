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
//    private final WorkTaskDAO workTaskDAO;

    private final WorkTaskMapper workTaskMapper;
    private final ActIdMembershipMapper actIdMembershipMapper;
    private final Transformer transformer;
    private final ExcelGenerator excelGenerator;

//    private final ActIdMembershipDAO actIdMembershipDAO;
    private final int pageSize;

    public WorkTaskBOImpl(WorkTaskMapper workTaskMapper, ActIdMembershipMapper actIdMembershipMapper, Transformer transformer, ExcelGenerator excelGenerator) {
//        this.workTaskDAO = workTaskDAO;
        this.workTaskMapper = workTaskMapper;
        this.actIdMembershipMapper = actIdMembershipMapper;
        this.transformer = transformer;
        this.excelGenerator = excelGenerator;
//        this.actIdMembershipDAO = actIdMembershipDAO;
        this.pageSize = 5;
    }

    @Override
    public Page<WorkTaskDTO> getAllWorkTasks(Pageable pageable, WorkTaskRequestDTO workTaskRequestDTO) throws Exception {

        Integer counter = actIdMembershipMapper.getUserGroupId(workTaskRequestDTO.getLoggedUser());
        workTaskRequestDTO.setLoggedUser(counter>0? workTaskRequestDTO.getLoggedUser():null);

        List<WorkTask> workTaskPage = workTaskMapper.getAll(pageable, workTaskRequestDTO.getWfRef(), workTaskRequestDTO.getStartDate(), workTaskRequestDTO.getEndDate(), workTaskRequestDTO.getClientId(), workTaskRequestDTO.getProjectId(), workTaskRequestDTO.getTaskOverallStatus(), workTaskRequestDTO.getDeveloper(), workTaskRequestDTO.getWorkType(), workTaskRequestDTO.getChargeStatus(), workTaskRequestDTO.getJobTypeId(),workTaskRequestDTO.getPendingUser(),workTaskRequestDTO.getLoggedUser());
//        Page<WorkTask> page = (Page<WorkTask>) workTaskPage;
//        System.out.println("==============>Total eleents "+ page.getTotalElements());
        List<WorkTaskDTO> worktaskDTOList = workTaskPage.stream().map(transformer::fromEntity).collect(Collectors.toList());
//        Long totalCount = workTaskMapper.getTotalCount(workTaskDTO.getWfRef(), workTaskDTO.getStartDate(), workTaskDTO.getEndDate(), workTaskDTO.getClientId(), workTaskDTO.getProjectId(), workTaskDTO.getTaskOverallStatus(), workTaskDTO.getDeveloper(), workTaskDTO.getWorkType(), workTaskDTO.getChargeStatus(), workTaskDTO.getJobTypeId(),workTaskDTO.getPendingUser(),workTaskDTO.getClientUserId());
        Long totalCount = workTaskMapper.getTotalCounts();
//        Date today = new Date();
//        WorkTaskCounter counts = workTaskMapper.getCounts(workTaskRequestDTO.getWfRef(), workTaskRequestDTO.getStartDate(), workTaskRequestDTO.getEndDate(), workTaskRequestDTO.getClientId(), workTaskRequestDTO.getProjectId(), workTaskRequestDTO.getTaskOverallStatus(), workTaskRequestDTO.getDeveloper(), workTaskRequestDTO.getWorkType(), workTaskRequestDTO.getChargeStatus(), workTaskRequestDTO.getJobTypeId(), workTaskRequestDTO.getPendingUser(), workTaskRequestDTO.getLoggedUser(),today);
//        System.out.println(counts);
//        Long totalCount =counts.getTotalCount();
//        Long lateCount =counts.getLateCount();
//        Long withinDueCountPercentage = (totalCount - lateCount)*100;
//        counts.setWithinDueDatePercentage(Math.round(((totalCount - lateCount) / (double) totalCount) * 10000.0) / 100.0);
//        counts.setLatePercentage(Math.round((lateCount / (double) totalCount) * 10000.0) / 100.0);
//        CustomPage workTaskDTOSPage = new CustomPage(worktaskDTOList, (PageRequest) pageable, totalCount, counts);
//        return workTaskDTOSPage;
        return new PageImpl<>(worktaskDTOList, pageable, totalCount);

    }

    @Override
    public WorkTaskCounter getWorkTasksCountList(WorkTaskRequestDTO workTaskRequestDTO) throws Exception {

        Integer counter = actIdMembershipMapper.getUserGroupId(workTaskRequestDTO.getLoggedUser());
        workTaskRequestDTO.setLoggedUser(counter>0? workTaskRequestDTO.getLoggedUser():null);

//        List<WorkTask> workTaskPage = workTaskMapper.getAll(pageable, workTaskRequestDTO.getWfRef(), workTaskRequestDTO.getStartDate(), workTaskRequestDTO.getEndDate(), workTaskRequestDTO.getClientId(), workTaskRequestDTO.getProjectId(), workTaskRequestDTO.getTaskOverallStatus(), workTaskRequestDTO.getDeveloper(), workTaskRequestDTO.getWorkType(), workTaskRequestDTO.getChargeStatus(), workTaskRequestDTO.getJobTypeId(),workTaskRequestDTO.getPendingUser(),workTaskRequestDTO.getLoggedUser());
//        Page<WorkTask> page = (Page<WorkTask>) workTaskPage;
//        System.out.println("==============>Total eleents "+ page.getTotalElements());
//        List<WorkTaskDTO> worktaskDTOList = workTaskPage.stream().map(transformer::fromEntity).collect(Collectors.toList());
//        Long totalCount = workTaskMapper.getTotalCount(workTaskDTO.getWfRef(), workTaskDTO.getStartDate(), workTaskDTO.getEndDate(), workTaskDTO.getClientId(), workTaskDTO.getProjectId(), workTaskDTO.getTaskOverallStatus(), workTaskDTO.getDeveloper(), workTaskDTO.getWorkType(), workTaskDTO.getChargeStatus(), workTaskDTO.getJobTypeId(),workTaskDTO.getPendingUser(),workTaskDTO.getClientUserId());
//        Long totalCount1 = workTaskMapper.getTotalCounts();
        Date today = new Date();
        System.out.println(today);
        WorkTaskCounter counts = workTaskMapper.getCounts(workTaskRequestDTO.getWfRef(), workTaskRequestDTO.getStartDate(), workTaskRequestDTO.getEndDate(), workTaskRequestDTO.getClientId(), workTaskRequestDTO.getProjectId(), workTaskRequestDTO.getTaskOverallStatus(), workTaskRequestDTO.getDeveloper(), workTaskRequestDTO.getWorkType(), workTaskRequestDTO.getChargeStatus(), workTaskRequestDTO.getJobTypeId(), workTaskRequestDTO.getPendingUser(), workTaskRequestDTO.getLoggedUser(),today);
//        System.out.println(counts);
        Long totalCount =counts.getTotalCount();
        Long lateCount =counts.getLateCount();
//        Long withinDueCountPercentage = (totalCount - lateCount)*100;
        counts.setWithinDueDatePercentage(Math.round(((totalCount - lateCount) / (double) totalCount) * 10000.0) / 100.0);
        counts.setLatePercentage(Math.round((lateCount / (double) totalCount) * 10000.0) / 100.0);
//        CustomPage workTaskDTOSPage = new CustomPage(worktaskDTOList, (PageRequest) pageable, totalCount, counts);
        return  counts;
//        return new PageImpl<>(worktaskDTOList, pageable, totalCount);

    }

    @Override
    public ByteArrayInputStream getWorkTaskListExcel(Pageable pageable, WorkTaskRequestDTO workTaskRequestDTO) throws Exception {
        Integer counter = actIdMembershipMapper.getUserGroupId(workTaskRequestDTO.getLoggedUser());
        workTaskRequestDTO.setLoggedUser(counter>0? workTaskRequestDTO.getLoggedUser():null);
        List<WorkTask> workTaskPage = workTaskMapper.getAll(pageable, workTaskRequestDTO.getWfRef(), workTaskRequestDTO.getStartDate(), workTaskRequestDTO.getEndDate(), workTaskRequestDTO.getClientId(), workTaskRequestDTO.getProjectId(), workTaskRequestDTO.getTaskOverallStatus(), workTaskRequestDTO.getDeveloper(), workTaskRequestDTO.getWorkType(), workTaskRequestDTO.getChargeStatus(), workTaskRequestDTO.getJobTypeId(),workTaskRequestDTO.getPendingUser(),workTaskRequestDTO.getLoggedUser());
//        System.out.println("pageable at bo"+pageable);
//        Page<WorkTask> page = (Page<WorkTask>) workTaskPage;
//        System.out.println("==============>Total eleents "+ page.getTotalElements());
        List<WorkTaskDTO> worktaskDTOList = workTaskPage.stream().map(transformer::fromEntity).collect(Collectors.toList());
//        System.out.println("workflow list size"+workTaskPage.size());
        ByteArrayInputStream byteArrayInputStream = excelGenerator.dateToExcel(worktaskDTOList);
        return byteArrayInputStream;
//
    }


    @Override
    public void updateWorkTaskByWfRef(String wfRef,WorkTaskRequestDTO workTaskDTO) throws Exception {
//        workTaskDAO.updateWorkTask(wfRef,workTaskDTO.getJobType(),workTaskDTO.getTaskName(), workTaskDTO.getChargeStatus(), workTaskDTO.getAllocatedTime(),workTaskDTO.getSubmissionDate(), workTaskDTO.getWorkType(), workTaskDTO.getBugFixType(), workTaskDTO.getWorkDescription() , workTaskDTO.getTaskType(), workTaskDTO.getWorkPriority());

    }
}
