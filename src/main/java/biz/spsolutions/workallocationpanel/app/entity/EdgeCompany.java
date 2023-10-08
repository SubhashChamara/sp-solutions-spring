package biz.spsolutions.workallocationpanel.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EdgeCompany implements Serializable {

    private int id;
    private String companyId;
    private String companyName;
    private Boolean status;
    private Date createDate;


}
