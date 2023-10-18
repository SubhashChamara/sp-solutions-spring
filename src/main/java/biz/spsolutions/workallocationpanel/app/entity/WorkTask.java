package biz.spsolutions.workallocationpanel.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkTask implements Serializable {

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
    private String accountManager;
    private String developerManager;

//    private String taskType;


}
