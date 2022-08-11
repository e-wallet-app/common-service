package com.ewallet.admin.service.definition;

import com.ewallet.admin.dto.request.ReqAdminDto;
import com.ewallet.admin.dto.response.ResAdminDto;

import java.util.List;

public interface IAdminService
{
    ResAdminDto getAdmin(String id) throws Exception;

    List<ResAdminDto> getAllAdmin();

    void createAdmin(ReqAdminDto reqAdminDto);

    void updateAdmin(String id, ReqAdminDto reqAdminDto);

    void deleteAdmin(String id) throws Exception;
}
