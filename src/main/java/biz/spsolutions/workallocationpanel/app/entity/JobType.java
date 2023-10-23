package biz.spsolutions.workallocationpanel.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobType implements Serializable {
    private int id;
    private String name;
}
