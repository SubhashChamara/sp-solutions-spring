package biz.spsolutions.workallocationpanel.app.dto;

import biz.spsolutions.workallocationpanel.app.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkTaskDTO_Old {

    private Long id;
    private String workType;
    private String workDescription;
    private String comment;
    private String taskName;
    private String workPriority;
    private String requestedBy;
    private String workTaskStatus;  // INFORMED  , HOLD  , COMPLETE , ALLOCATED
    private String chargeStatus;    //FOC,Charge,Maintainance
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
    private Boolean active = true;
    private Boolean startWorkflow = false;
    private Boolean startReleas = false;
    private String allocatedDays;
    private String allocatedHours;
    private String allocatedMins;
    private String allocatedTimeString;
    private Long allocatedDuration;
    private String status; //Flow Status
    private String taskOverallStatus; //Flow Status & dev.status
    private String taskOverallStatusPrevious;
    private String businesskey;
    private String processinstance;
    private Boolean flowInvoked=false;
    private String developmentStatus;
    private Date submitionDate;
    private Boolean taskBlock=false;
    private Boolean taskCompleted=false;
    private Boolean jcPassed = false;
    private Boolean ursPassed = false;
    private Boolean srsPassed = false;
    private Boolean qaPassed = false;
    private Boolean selectedForDownload = true;
    private Date autoStopedTime;
    private Date discardedDate;
    private ActIdUser discardedUser;
    private String statusOtherUser="NEW";
    private Boolean newCommentAdded=false;
    private String commentAddedUser;
    private Integer wfStatus = 0;
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
