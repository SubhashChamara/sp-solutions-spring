package biz.spsolutions.workallocationpanel.app.api;

import biz.spsolutions.workallocationpanel.app.business.TesterBO;
import biz.spsolutions.workallocationpanel.app.dto.TesterDTO;
import biz.spsolutions.workallocationpanel.app.dto.WorkTaskDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tester")
public class TesterController {
    private final TesterBO testerBO;

    public TesterController(TesterBO testerBO) {
        this.testerBO = testerBO;
    }


    @GetMapping
    public List<TesterDTO> getAllTasks() throws Exception {
        System.out.println("'api tester"+testerBO.getAllWorkTasks());
        return testerBO.getAllWorkTasks();
    }
}
