package biz.spsolutions.workallocationpanel.app.dao;

import biz.spsolutions.workallocationpanel.app.dao.mapper.TesterMapper;
import biz.spsolutions.workallocationpanel.app.entity.Tester;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Repository
public class TesterDAO {
    private final TesterMapper testerMapper;

    public TesterDAO(TesterMapper testerMapper) {
        this.testerMapper =testerMapper;
    }


    public List<Tester> getAll() throws Exception {
        System.out.println("dao come");
        System.out.println(testerMapper.getAll());
        return testerMapper.getAll();
    }
}
