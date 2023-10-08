package biz.spsolutions.workallocationpanel.app.business;

import biz.spsolutions.workallocationpanel.app.business.util.Transformer;
import biz.spsolutions.workallocationpanel.app.dao.WorkTaskDAO;
import biz.spsolutions.workallocationpanel.app.dto.WorkTaskDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public interface WorkTaskBO {

    public List<WorkTaskDTO> getAllWorkTasks(WorkTaskDTO workTaskDTO) throws Exception ;
}
