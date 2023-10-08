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
public class Project implements Serializable {
    private Integer id;
    private String projectName;
    private String projectDescription;
    private String projectStatus;
    private Client client;
    private Boolean active;
    private ActIdUser createdUser;
    private Date createdDate;
    private String teamName;
    private Double amount;
    private String quarter;

}
