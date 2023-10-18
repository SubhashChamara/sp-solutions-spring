package biz.spsolutions.workallocationpanel.app.business;

import biz.spsolutions.workallocationpanel.app.dto.WorkTaskRequestDTO;
import biz.spsolutions.workallocationpanel.app.dto.WorkTaskDTO;
import biz.spsolutions.workallocationpanel.app.dto.WorkTaskResponseDTO;
import biz.spsolutions.workallocationpanel.app.entity.WorkTaskCounter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;

@Service
public interface WorkTaskBO {
    public Page<WorkTaskDTO> getAllWorkTasks(Pageable pageable, WorkTaskRequestDTO workTaskRequestDTO) throws Exception ;
    public WorkTaskCounter getWorkTasksCountList(WorkTaskRequestDTO workTaskRequestDTO) throws Exception ;

    public ByteArrayInputStream getWorkTaskListExcel(Pageable pageable, WorkTaskRequestDTO workTaskRequestDTO)throws Exception;

    public void updateWorkTaskByWfRef(String wfRef,WorkTaskRequestDTO workTaskDTO) throws Exception ;
}
