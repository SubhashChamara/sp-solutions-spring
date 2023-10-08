package biz.spsolutions.workallocationpanel.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentHead implements Serializable {

    private Long id;
    private String contactNo;
    private String departmentHeadName;
    private String departmentHeadStatus;
    private String email;
    private String firstName;
    private String fullName;
    private String lastName;

}
