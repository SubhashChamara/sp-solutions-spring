package biz.spsolutions.workallocationpanel.app.dao.mapper;

import biz.spsolutions.workallocationpanel.app.entity.Tester;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TesterMapper {
//    @Results(id = "testerResultMap", value = {
//            @Result(property = "nameNew", column = "name"),
//            @Result(property = "address", column = "address"),
//            @Result(property = "supervisorName", column = "supervisor_name")
//    })
//    @Select("SELECT * FROM Tester")
    List<Tester> getAll();
}
