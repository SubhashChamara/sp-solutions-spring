package biz.spsolutions.workallocationpanel.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO implements Serializable {

    private int id;
    private String name;

}
