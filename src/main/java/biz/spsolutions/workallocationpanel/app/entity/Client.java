package biz.spsolutions.workallocationpanel.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client implements Serializable {

    private Integer id;
    private String clientName;
    private String description;
    private String clientEmail;
    private String clientAddress;
    private String clientContactNo;
    private String clientStatus;
    private String contacrPersonEmail;
    private String contactPersonName;
    private String contactPersonNo;
    private Boolean active;
    private ActIdUser createdUser;
    private Date createdDate;
}
