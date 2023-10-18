package biz.spsolutions.workallocationpanel.app.dto;

import biz.spsolutions.workallocationpanel.app.entity.WorkTask;
import biz.spsolutions.workallocationpanel.app.entity.WorkTaskCounter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkTaskResponseDTO implements Serializable {

    private List<WorkTaskDTO>  workTask;
    private WorkTaskCounter workTaskCounter;
}
