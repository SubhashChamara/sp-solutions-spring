package biz.spsolutions.workallocationpanel.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.internal.bytebuddy.implementation.bind.annotation.Super;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tester implements Serializable {
    String nameNew;
    String address;
    Supervisor supervisor;

}
