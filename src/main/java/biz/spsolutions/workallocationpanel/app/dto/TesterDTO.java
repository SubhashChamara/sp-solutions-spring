package biz.spsolutions.workallocationpanel.app.dto;

import biz.spsolutions.workallocationpanel.app.entity.Client;
import biz.spsolutions.workallocationpanel.app.entity.Supervisor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.internal.bytebuddy.implementation.bind.annotation.Super;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TesterDTO {
    String nameNew;
    String address;
    Supervisor supervisor;

}
