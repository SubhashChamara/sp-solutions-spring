package biz.spsolutions.workallocationpanel.app.dao;

import biz.spsolutions.workallocationpanel.app.dao.mapper.WorkTaskMapper;
import biz.spsolutions.workallocationpanel.app.entity.WorkTask;
import biz.spsolutions.workallocationpanel.app.entity.WorkTaskOriginal;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Repository
public class WorkTaskDAO {
    private final WorkTaskMapper workTaskMapper;

    public WorkTaskDAO(WorkTaskMapper workTaskMapper) {
        this.workTaskMapper = workTaskMapper;
    }

    public List<WorkTask> getAll(String wfRef, Date startDate, Date endDate, Integer clientId, Integer projectId, String overallStatus, String developerId, String workType, String chargeType, BigInteger jobType,String userId,String pendingUser) throws Exception {
        System.out.println( workTaskMapper.getAll(wfRef,startDate,endDate,clientId,projectId,overallStatus,developerId,workType,chargeType,jobType,userId,pendingUser));
        return workTaskMapper.getAll(wfRef,startDate,endDate,clientId,projectId,overallStatus,developerId,workType,chargeType,jobType,userId,pendingUser);
    }
}
