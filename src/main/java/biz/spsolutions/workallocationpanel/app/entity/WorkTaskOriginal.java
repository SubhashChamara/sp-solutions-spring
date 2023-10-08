package biz.spsolutions.workallocationpanel.app.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkTaskOriginal implements Serializable {


    private Long id;
    private String workType;
    private String workDescription;
    private String comment;
    private String taskName;
    private String workPriority;
    private String requestedBy;
    private String workTaskStatus;
    private String chargeStatus;
    private String dHComment;
    private Date workStartDate;
    private Date workHoldDate;
    private Date workCompletedDate;
    private Long startTime;
    private Long holdTime;
    private Long elapsedTime;
    private Long elapsedTimeTotalOther;
    private String elapsedTimeTotalOtherString;
    private Boolean startStatus;
    private String elapsedTimeString;
    private Long currentTimeMills;
    private Project project;
    private User completedUser;
    private Client client;
    private MasterJobType jobType;
    private WorkAllocation workAllocation;
    private Integer version;
    private ActIdUser createUserId;
    private Date createDate;
    private String modifyUser;
    private Date modifyDate;
    private String fileNameReceipt;
    private Long docIdReceipt;
    private String allocatedTime;
    private Boolean active;
    private Boolean startWorkflow;
    private Boolean startRelease;
    private String allocatedDays;
    private String allocatedHours;
    private String allocatedMins;
    private String allocatedTimeString;
    private Long allocatedDuration;
    private String status; //Flow Status
    private String taskOverallStatus; //Flow Status & dev.status
    private String taskOverallStatusPrevious;
    private String businessKey;
    private String processInstance;
    private Boolean flowInvoked;
    private String developmentStatus;
    private Date submitionDate;
    private Boolean taskBlock;
    private Boolean taskCompleted;
    private Boolean jcPassed;
    private Boolean ursPassed;
    private Boolean srsPassed;
    private Boolean qaPassed;
    private Boolean selectedForDownload;
    private Date autoStoppedTime;
    private Date discardedDate;
    private ActIdUser discardedUser;
    private String statusOtherUser;
    private Boolean newCommentAdded;
    private String commentAddedUser;
    private Integer wfStatus;
    private String taskType;
    private Date monthDay;
    private String weekDay;
    private Date endDate;
    private String accountManager;
    private String bugFixType;
    private Date deletedTime;
    private String deletedBy;
    private Boolean selected;
    private ReleaseDeployment releaseDeployment;

}
