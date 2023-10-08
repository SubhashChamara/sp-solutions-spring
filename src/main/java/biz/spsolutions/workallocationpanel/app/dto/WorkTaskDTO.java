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

    private Date startDate;
    private Date endDate;
    private Integer clientId;
    private Integer projectId;
    private String developerId;
    private BigInteger jobTypeId;
    private String userId;
    private String pendingUser;


    @Override
    public String toString() {
        return "WorkTaskDTO{" +
                "wfRef='" + wfRef + '\'' +
                ", clientName='" + clientName + '\'' +
                ", projectName='" + projectName + '\'' +
                ", jobType='" + jobType + '\'' +
                ", taskName='" + taskName + '\'' +
                ", chargeStatus='" + chargeStatus + '\'' +
                ", allocatedTime='" + allocatedTime + '\'' +
                ", developer='" + developer + '\'' +
                ", elapsedTime='" + elapsedTime + '\'' +
                ", workCompletedDate=" + workCompletedDate +
                ", submissionDate=" + submissionDate +
                ", workType='" + workType + '\'' +
                ", bugFixType='" + bugFixType + '\'' +
                ", workDescription='" + workDescription + '\'' +
                ", workPriority='" + workPriority + '\'' +
                ", taskOverallStatus='" + taskOverallStatus + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", clientId=" + clientId +
                ", projectId=" + projectId +
                ", developerId='" + developerId + '\'' +
                ", jobTypeId=" + jobTypeId +
                ", userId='" + userId + '\'' +
                ", pendingUser='" + pendingUser + '\'' +
                '}';
    }
}
