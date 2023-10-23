package biz.spsolutions.workallocationpanel.app.mapper;

import biz.spsolutions.workallocationpanel.app.entity.Developer;
import biz.spsolutions.workallocationpanel.app.entity.Project;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeveloperMapper {

    List<Developer> getAll();

    }

