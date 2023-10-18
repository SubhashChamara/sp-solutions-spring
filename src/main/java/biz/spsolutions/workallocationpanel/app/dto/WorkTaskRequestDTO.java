package biz.spsolutions.workallocationpanel.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkTaskRequestDTO implements Serializable {

    private String wfRef;
    private Date startDate;
    private Date endDate;
    private Integer clientId;
    private Integer projectId;
    private BigInteger jobTypeId;
    private String workType;
    private String chargeStatus;
    private String taskOverallStatus;
    private String pendingUser;
    private String developer;
    private String loggedUser;

}
