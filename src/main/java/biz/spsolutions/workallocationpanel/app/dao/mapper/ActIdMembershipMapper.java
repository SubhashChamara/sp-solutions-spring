package biz.spsolutions.workallocationpanel.app.dao.mapper;

import biz.spsolutions.workallocationpanel.app.entity.WorkTask;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Pageable;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Mapper
public interface ActIdMembershipMapper {
    Integer getUserGroupId(String userId);
}
