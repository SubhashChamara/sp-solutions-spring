package biz.spsolutions.workallocationpanel.app.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActIdMembershipDAO {

    Integer getUserGroupId(String userId);

}
