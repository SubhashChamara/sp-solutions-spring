package biz.spsolutions.workallocationpanel.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkTaskCounter implements Serializable {

    private Long totalCount;
    private Long allocatedCount;
    private Long ongoingCount;
    private Long holdCount;
    private Long newCount;
    private Long lateCount;
    private Double withinDueDatePercentage;
    private Double latePercentage;
    private Long devCompletedCount;
    private Long devReturnCount;
    private Long qAPendingCount;
    private Long qACompletedCount;
    private Long completedCount;
    private Long inCompletedCount;
    private Long newRequirementCount;
    private Long newBusinessCount;
    private Long changeLogicCount;
    private Long changeRequirementCount;
    private Long bugFixCount;
    private Long complaintCount;

}
