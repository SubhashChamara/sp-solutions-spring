package biz.spsolutions.workallocationpanel.app.dao.mapper;

import biz.spsolutions.workallocationpanel.app.entity.WorkTaskOriginal;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ActIdUserMapper {

//    @Results({
//        @Result(property = "project",column = "project_ID"),
//
//    })
    @Select("SELECT * FROM worktask")
    List<WorkTaskOriginal> getAll();
}
