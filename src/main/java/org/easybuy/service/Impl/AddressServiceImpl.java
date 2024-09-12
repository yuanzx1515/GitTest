package org.easybuy.service.Impl;
import org.easybuy.entity.address;

import java.util.List;

public interface AddressServiceImpl {
    List<address> selectByAId(int A_id);
    void addAddress(String username,String address_line,String phone,int A_id);
    boolean insertUserNoll(String username, String address_line, String phone, int A_id);
    List<Integer> findADDByAId(int A_id);
    String findADDByAddId(int Add_id);
}
