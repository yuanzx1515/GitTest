package org.easybuy.service.Impl;

import sun.jvm.hotspot.debugger.Address;

import java.util.List;

public interface AddressServiceImpl {
    List<Address> selectByAId(int A_id);
}
