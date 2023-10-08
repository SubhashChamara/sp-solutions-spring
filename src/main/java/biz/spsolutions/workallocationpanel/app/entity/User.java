package biz.spsolutions.workallocationpanel.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private Long id;
    private String contactNo;
    private String email;
    private String firstName;
    private String fullName;
    private String lastName;
    private String userName;
    private String userStatus;
    private DepartmentHead departmentHead;

}
