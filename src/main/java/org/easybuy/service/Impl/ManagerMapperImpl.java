package org.easybuy.service.Impl;

import org.apache.ibatis.annotations.Param;
import org.easybuy.entity.User;

public interface ManagerMapperImpl {
    boolean findUserByUsername(String username);
    boolean findMangerUser(String username);
}
