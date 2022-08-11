package com.ewallet.admin.service.implementation;

import com.ewallet.admin.dto.request.ReqAdminDto;
import com.ewallet.admin.dto.response.ResAdminDto;
import com.ewallet.admin.entity.Admin;
import com.ewallet.admin.exception.NotFoundException;
import com.ewallet.admin.repository.AdminRepository;
import com.ewallet.admin.service.definition.IAdminService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService implements IAdminService
{
    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public ResAdminDto getAdmin(String id)
    {

        var resAdmin = new ResAdminDto();

        var admin = adminRepository.findById(Long.parseLong(id)).orElseThrow(() -> new NotFoundException("Not Found"));        //Finding the entity from the table
        BeanUtils.copyProperties(admin,resAdmin); //copying properties to responseAdmin
        return resAdmin;
    }

    @Override
    public List<ResAdminDto> getAllAdmin()
    {
        List<Admin> adminList = adminRepository.findAll();
        var resAdminList = new ArrayList<ResAdminDto>();
        var resAdmin = new ResAdminDto();

        for (Admin admin: adminList)
        {
            BeanUtils.copyProperties(resAdmin,admin);
            resAdminList.add(resAdmin);
        }
        return resAdminList;
    }

    @Override
    public void createAdmin(ReqAdminDto reqAdminDto)
    {
        var admin = new Admin();
        BeanUtils.copyProperties(reqAdminDto,admin);
        adminRepository.save(admin);
    }

    @Override
    public void updateAdmin(String id, ReqAdminDto reqAdminDto)
    {
        var admin = adminRepository.findById(Long.parseLong(id)).orElseThrow(() -> new NotFoundException("Not Found"));
        BeanUtils.copyProperties(reqAdminDto,admin);
        adminRepository.save(admin);
    }

    @Override
    public void deleteAdmin(String id)
    {
        adminRepository.deleteById(Long.parseLong(id));
    }
}
