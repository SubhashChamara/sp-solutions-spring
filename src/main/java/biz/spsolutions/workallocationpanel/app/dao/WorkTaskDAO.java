package biz.spsolutions.workallocationpanel.app.dao;

import biz.spsolutions.workallocationpanel.app.dao.mapper.WorkTaskMapper;
import biz.spsolutions.workallocationpanel.app.entity.WorkTask;
import biz.spsolutions.workallocationpanel.app.entity.WorkTaskOriginal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Repository
public interface WorkTaskDAO {

    public List<WorkTask> getAll(Pageable pageable, String wfRef, Date startDate, Date endDate, Integer clientId, Integer projectId, String overallStatus, String developerId, String workType, String chargeType, BigInteger jobType, String userId, String pendingUser,String clientUserId) throws Exception;
    public Long getTotalCount(String wfRef, Date startDate, Date endDate, Integer clientId, Integer projectId, String overallStatus, String developerId, String workType, String chargeType, BigInteger jobType, String userId, String pendingUser) throws Exception;

    public void updateWorkTask(String wfRef,String jobType, String taskName, String chargeType, String allocatedTimeString, Date submissionDate, String workType, String bugFixType, String workDescription, String taskType, String workPriority) throws Exception;


}
