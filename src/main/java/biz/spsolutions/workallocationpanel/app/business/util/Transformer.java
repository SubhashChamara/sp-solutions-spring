package biz.spsolutions.workallocationpanel.app.business.util;

import biz.spsolutions.workallocationpanel.app.dto.TesterDTO;
import biz.spsolutions.workallocationpanel.app.dto.WorkTaskDTO;
import biz.spsolutions.workallocationpanel.app.entity.Tester;
import biz.spsolutions.workallocationpanel.app.entity.WorkTask;
import biz.spsolutions.workallocationpanel.app.entity.WorkTaskOriginal;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Transformer {
    private final ModelMapper modelMapper =new ModelMapper();

    public WorkTaskDTO fromEntity(WorkTask workTask) {
        return modelMapper.map(workTask, WorkTaskDTO.class);
    }

    public WorkTask toEntity(WorkTaskDTO workTaskDTO) {
        return modelMapper.map(workTaskDTO, WorkTask.class);
    }

    public TesterDTO fromEntityTester(Tester tester) {
        System.out.println("TesterTransform"+modelMapper.map(Tester.class, TesterDTO.class));
        return modelMapper.map(tester, TesterDTO.class);
    }

    public Tester toEntityTester(TesterDTO testerDTO) {
        return modelMapper.map(testerDTO, Tester.class);
    }
}
