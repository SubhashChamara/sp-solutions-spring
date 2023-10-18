package biz.spsolutions.workallocationpanel.app.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ActIdMembershipMapper {
    Integer getUserGroupId(String userId);
}
