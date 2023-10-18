package biz.spsolutions.workallocationpanel.page;

import biz.spsolutions.workallocationpanel.app.dto.WorkTaskDTO;
import biz.spsolutions.workallocationpanel.app.entity.WorkTaskCounter;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class CustomPage extends PageImpl<WorkTaskDTO> {
    private WorkTaskCounter workTaskCounter;

    public CustomPage(List<WorkTaskDTO> content, PageRequest pageRequest, long total, WorkTaskCounter workTaskCounter) {
        super(content, pageRequest, total);
        this.workTaskCounter = workTaskCounter;
    }

    public WorkTaskCounter getWorkTaskCounter() {
        return workTaskCounter;
    }
}
