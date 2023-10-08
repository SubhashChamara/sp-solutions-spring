package biz.spsolutions.workallocationpanel.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActIdUser implements Serializable {
    private String id;
    private String email;
    private String first;
    private String last;
    private String designation;
    private String phone;
    private String pictureId;
    private String pwd;
    private int rev;
    private String role;
    private String status;
    private Integer locked;
    private Date lockedDate;
    private Integer passwordReset;
    private EdgeCompany edgeCompany;
    private Date passwordResetDate;
    private String passwordResetBy;
    private Date passwordChangedDate;
    private Date lastActivityDate;
    private String passwordResetByFullName;
    private String taskpad_order;
    private EdgeActualDepartment actualDep;

    private Integer resetUserRandomNum;

    private String linkedinAdd;

    private String googlePlusAdd;

    private String facebookAdd;

    private String clientWiseEmail;

    private String employeeNumber;

}
