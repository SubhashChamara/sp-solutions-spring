package biz.spsolutions.workallocationpanel.app.business;

import biz.spsolutions.workallocationpanel.app.business.util.Transformer;
import biz.spsolutions.workallocationpanel.app.dao.TesterDAO;
import biz.spsolutions.workallocationpanel.app.dao.WorkTaskDAO;
import biz.spsolutions.workallocationpanel.app.dto.TesterDTO;
import biz.spsolutions.workallocationpanel.app.dto.WorkTaskDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TesterBO {
    private final TesterDAO testerDAO;
    private final Transformer transformer;

    public TesterBO(TesterDAO testerDAO, Transformer transformer) {
        this.testerDAO = testerDAO;
        this.transformer = transformer;
    }


    public List<TesterDTO> getAllWorkTasks() throws Exception {
        System.out.println("bo come"+testerDAO.getAll());
     return testerDAO.getAll().stream().map(transformer::fromEntityTester).collect(Collectors.toList());
    }
}
