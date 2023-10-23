package biz.spsolutions.workallocationpanel.app.mapper;

import biz.spsolutions.workallocationpanel.app.entity.Client;
import biz.spsolutions.workallocationpanel.app.entity.Project;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MasterProject {

    List<Project> getAllByClient(int clientId);

    }

