package com.ewallet.admin.service;

import com.ewallet.admin.dto.requestDto.ReqAdmin;
import com.ewallet.admin.dto.responseDto.ResAdmin;

import java.util.List;

public interface AdminService
{
    ResAdmin getAdmin(String id) throws Exception;

    List<ResAdmin> getAllAdmin();

    void createAdmin(ReqAdmin reqAdmin);

    void updateAdmin(String id, ReqAdmin reqAdmin);

    void deleteAdmin(String id) throws Exception;
}
