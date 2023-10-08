package biz.spsolutions.workallocationpanel.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EdgeActualDepartment implements Serializable {
    private int id;
    private String departmentName;
    private Date createDate;
    private String unitType;
    private EdgeCompany company;
    private Boolean active;
}
