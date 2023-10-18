package biz.spsolutions.workallocationpanel.app.business.util;

import biz.spsolutions.workallocationpanel.app.dto.WorkTaskRequestDTO;
import biz.spsolutions.workallocationpanel.app.dto.WorkTaskDTO;
import biz.spsolutions.workallocationpanel.app.entity.WorkTask;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Transformer {
    private final ModelMapper modelMapper =new ModelMapper();

    public WorkTaskDTO fromEntity(WorkTask workTask) {
        return modelMapper.map(workTask, WorkTaskDTO.class);
    }

    public WorkTask toEntity(WorkTaskRequestDTO workTaskRequestDTO) {
        return modelMapper.map(workTaskRequestDTO, WorkTask.class);
    }

}
