package biz.spsolutions.workallocationpanel.app.dao.impl;

import biz.spsolutions.workallocationpanel.app.dao.WorkTaskDAO;
import biz.spsolutions.workallocationpanel.app.dao.mapper.WorkTaskMapper;
import biz.spsolutions.workallocationpanel.app.entity.WorkTask;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Repository
public class WorkTaskDAOImpl implements WorkTaskDAO {
    private final WorkTaskMapper workTaskMapper;

    public WorkTaskDAOImpl(WorkTaskMapper workTaskMapper) {
        this.workTaskMapper = workTaskMapper;
    }



    @Override
    public List<WorkTask> getAll(Pageable pageable, String wfRef, Date startDate, Date endDate, Integer clientId, Integer projectId, String overallStatus, String developerId, String workType, String chargeType, BigInteger jobType, String userId, String pendingUser,String clientUserId) throws Exception {
        System.out.println("start to dao");
        System.out.println("logged user at dao "+clientUserId);
//        System.out.println(workTaskMapper.getAll(wfRef, startDate, endDate, clientId, projectId, overallStatus, developerId, workType, chargeType, jobType, userId, pendingUser));
        List<WorkTask> workTaskPage = workTaskMapper.getAll(pageable, wfRef, startDate, endDate, clientId, projectId, overallStatus, developerId, workType, chargeType, jobType, userId, pendingUser,clientUserId);

        System.out.println("worktaskpage return from DAO"+workTaskPage);
        return workTaskPage;
    }


    @Override
    public Long getTotalCount(String wfRef, Date startDate, Date endDate, Integer clientId, Integer projectId, String overallStatus, String developerId, String workType, String chargeType, BigInteger jobType, String userId, String pendingUser) throws Exception {
        Long totalCount = workTaskMapper.getTotalCount(wfRef, startDate, endDate, clientId, projectId, overallStatus, developerId, workType, chargeType, jobType, userId, pendingUser);
        System.out.println("total Count "+totalCount);
        return totalCount;
    }

    @Override
    public void updateWorkTask(String wfRef,String jobType, String taskName, String chargeType, String allocatedTimeString, Date submissionDate, String workType, String bugFixType, String workDescription, String taskType, String workPriority) throws Exception {
        workTaskMapper.updateWorkTask(wfRef,jobType,taskName,chargeType,allocatedTimeString,submissionDate,workType,bugFixType,workDescription,taskType,workPriority);
    }
}
