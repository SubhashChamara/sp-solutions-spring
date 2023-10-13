package biz.spsolutions.workallocationpanel.app.dto;

import biz.spsolutions.workallocationpanel.app.entity.*;
import lombok.*;

import java.math.BigInteger;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkTaskDTO {

    private String wfRef;
    private String clientName;
    private String projectName;
    private String jobType;
    private String taskName;
    private String chargeStatus;
    private String allocatedTime;
    private String developer;
    private String elapsedTime;
    private Date workCompletedDate;
    private Date submissionDate;
    private String workType;
    private String bugFixType;
    private String workDescription;
    private String workPriority;
    private String taskOverallStatus;

    //Search
    private Date startDate;
    private Date endDate;
    private Integer clientId;
    private Integer projectId;
    private BigInteger jobTypeId;
    private String userId;
    private String pendingUser;
    private String clientUserId;


    //For Update
    private String taskType;


}
