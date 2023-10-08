package biz.spsolutions.workallocationpanel.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MasterJobType implements Serializable {
    private Long id;
    private Project project;
    private String jobType;
    private String description;
    private Boolean active;
    private ActIdUser createdUser;
    private Date createdDate;
    private String teamName;
    private Double amount;
    private String quarter;
    private Boolean completed;
    private Integer status;
    private Date deliveryDate;
    private Integer qaRound;
    private Integer numberOfErrors;
    private Integer targetDays;
    private Integer year;
    private Boolean jobPerformance;
    private String jobStatus;
    private Date completedDate;
    private ActIdUser fkDeveloper;

}
