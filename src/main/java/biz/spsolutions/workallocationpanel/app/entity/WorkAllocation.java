package biz.spsolutions.workallocationpanel.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkAllocation implements Serializable {

    private Long id;
    private Date createdDate;
    private ActIdUser modifiedUser;
    private Date modifiedDate;
    private ActIdUser createdUserId;
    private ActIdUser accountManager;
    private ActIdUser departmentHeadUser;
    private ActIdUser manager;
    private ActIdUser assignedDeveloper; //Assign developer
    private Date departmentHeadAssignDate;
    private Date developerAssignedDate;
    private Date userReAssignDate;
    private String taskCompleteUser;
    private Date flowCompletedDate;
    private Boolean flowCompleted;
    private String userComment ;
    private String testCompleteUser;
    private Date testCompleteDate;
    private String QAComment ;
    private String workAllocationStatus;    // Requested  // Assign To HD // Assign To User // Hold //Stated // Completed // Checked // Approved //
    private String developerWorkAllocationStatus;    //
    private String status;
    private String businesskey;
    private String processinstance;
    private Boolean developerReAssignede;
    private ActIdUser assignedQa;
    private ActIdUser assignedCodeReviewer;
}
