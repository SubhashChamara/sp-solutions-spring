package biz.spsolutions.workallocationpanel.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobTypeDTO implements Serializable {

    private int id;
    private String name;

}
