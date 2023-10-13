package biz.spsolutions.workallocationpanel.app.business;

import biz.spsolutions.workallocationpanel.app.business.util.Transformer;
import biz.spsolutions.workallocationpanel.app.dao.WorkTaskDAO;
import biz.spsolutions.workallocationpanel.app.dto.WorkTaskDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public interface WorkTaskBO {
    public Page<WorkTaskDTO> getAllWorkTasks(Pageable pageable, WorkTaskDTO workTaskDTO) throws Exception ;
    public void updateWorkTaskByWfRef(String wfRef,WorkTaskDTO workTaskDTO) throws Exception ;
}
