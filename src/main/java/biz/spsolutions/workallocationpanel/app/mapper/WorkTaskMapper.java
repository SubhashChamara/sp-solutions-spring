package biz.spsolutions.workallocationpanel.app.mapper;

import biz.spsolutions.workallocationpanel.app.entity.WorkTask;
import biz.spsolutions.workallocationpanel.app.entity.WorkTaskCounter;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Pageable;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
@Mapper
public interface WorkTaskMapper {

    List<WorkTask> getAll(Pageable pageable, String wfRef, Date startDate, Date endDate, Integer clientId, Integer projectId, String overallStatus, String developerId, String workType, String chargeType, BigInteger jobType, String pendingUser,String clientUserId);
    Long getTotalCount(String wfRef, Date startDate, Date endDate, Integer clientId, Integer projectId, String overallStatus, String developerId, String workType, String chargeType, BigInteger jobType, String pendingUser,String clientUserId);
    Long getTotalCounts();
    WorkTaskCounter getCounts(String wfRef, Date startDate, Date endDate, Integer clientId, Integer projectId, String overallStatus, String developerId, String workType, String chargeType, BigInteger jobType, String pendingUser, String clientUserId,Date today);
    void updateWorkTask(String wfRef,String jobType, String taskName, String chargeType, String allocatedTimeString, Date submissionDate, String workType, String bugFixType, String workDescription, String taskType, String workPriority);
}
