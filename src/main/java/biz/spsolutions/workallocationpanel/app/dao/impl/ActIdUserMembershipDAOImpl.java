package biz.spsolutions.workallocationpanel.app.dao.impl;

import biz.spsolutions.workallocationpanel.app.dao.ActIdMembershipDAO;
import biz.spsolutions.workallocationpanel.app.dao.mapper.ActIdMembershipMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ActIdUserMembershipDAOImpl implements ActIdMembershipDAO {
    private final ActIdMembershipMapper actIdMembershipMapper;

    public ActIdUserMembershipDAOImpl(ActIdMembershipMapper actIdMembershipMapper) {
        this.actIdMembershipMapper = actIdMembershipMapper;
    }
    @Override
    public Integer getUserGroupId(String userId) {
      return actIdMembershipMapper.getUserGroupId(userId);
    }
}
