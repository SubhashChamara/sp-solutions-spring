package biz.spsolutions.workallocationpanel.app.dao.mapper;

import biz.spsolutions.workallocationpanel.app.entity.WorkTask;
import biz.spsolutions.workallocationpanel.app.entity.WorkTaskOriginal;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
@Mapper
public interface WorkTaskMapper {

//    @Results({
//        @Result(property = "project",column = "project_ID"),
//        @Result(property = "completedUser",column = "completed_user_ID"),
//        @Result(property = "client",column = "client_ID"),
//        @Result(property = "jobType",column = "fk_job_type"),
//        @Result(property = "workAllocation",column = "workAllocation_ID"),
//        @Result(property = "version",column = "lockversion"),
//        @Result(property = "createUserId",column = "created_user_ID"),
//        @Result(property = "discardedUser",column = "fk_discarded_user"),
//        @Result(property = "discardedUser",column = "fk_discarded_user"),
//        @Result(property = "accountManager",column = "FK_ACC_MAN_"),
//        @Result(property = "bugFixType",column = "BUG_FIX_TYPE"),
//        @Result(property = "deletedTime",column = "DELETED_DATE"),
//        @Result(property = "deletedBy",column = "DELETED_BY"),
//        @Result(property = "selected",column = "SELECTED"),
//        @Result(property = "releaseDeployment",column = "FK_RELEASE_DEPLOYMENT"),
//    })

    List<WorkTask> getAll(Pageable pageable, String wfRef, Date startDate, Date endDate, Integer clientId, Integer projectId, String overallStatus, String developerId, String workType, String chargeType, BigInteger jobType, String userId, String pendingUser,String clientUserId);
    Long getTotalCount(String wfRef, Date startDate, Date endDate, Integer clientId, Integer projectId, String overallStatus, String developerId, String workType, String chargeType, BigInteger jobType, String userId, String pendingUser);

    void updateWorkTask(String wfRef,String jobType, String taskName, String chargeType, String allocatedTimeString, Date submissionDate, String workType, String bugFixType, String workDescription, String taskType, String workPriority);
}
