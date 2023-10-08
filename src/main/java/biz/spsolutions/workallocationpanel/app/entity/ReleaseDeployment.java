package biz.spsolutions.workallocationpanel.app.entity;

import jakarta.annotation.security.DenyAll;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReleaseDeployment implements Serializable {

    private long id;
    private Client clientId;
    private Date createDate;
    private String createUser;
    private String taskInstance;
    private String product;
    private String solution;
    private String reference;
    private Date projectStartDate;
    private Date projectEndDate;
    private String notes;
    private String businessKey;
    private String uniqueKey;
    private String processInstance;
    private String workflowReferenceName;
    private String workFlowStatusLabel;
    private Integer workFlowStatus;
    private String invokedGroup;
    private Integer version;
    private Boolean isActive;
    private String assignedDeveloper;
    private ActIdUser assignedDeveloperId;
    private ActIdUser assignedDeveloperMangerId;
    private ActIdUser createdUserId;
    private ActIdUser qAUserId;
    private ActIdUser qAManagerUserId;
    private ActIdUser approver1UserId;
    private Boolean approver1Approved;
    private ActIdUser approver2UserId;
    private Boolean approver2Approved;
    private Date releaseDate;
    private String releaseVersion;
    private String releaseType;
    private Boolean developerManagerApproved;
    private Boolean qaApproved;
    private Boolean qaNotConfirmed;
    private Boolean qaManagerApproved ;
    private Boolean releaseNoteSent;
    private Boolean passwordChanged;
    private Boolean formSaved;
    private Boolean passwordReleaseRequired;
    private Boolean isUpdatable = false;
    private Boolean approveStatus = false;
}
