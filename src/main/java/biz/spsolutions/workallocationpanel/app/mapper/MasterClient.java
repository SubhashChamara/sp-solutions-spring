package biz.spsolutions.workallocationpanel.app.mapper;

import biz.spsolutions.workallocationpanel.app.entity.Client;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MasterClient {

    List<Client> getAll();

    }

