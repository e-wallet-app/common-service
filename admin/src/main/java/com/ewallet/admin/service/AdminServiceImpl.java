package com.ewallet.admin.service;

import com.ewallet.admin.dto.requestDto.ReqAdmin;
import com.ewallet.admin.dto.responseDto.ResAdmin;
import com.ewallet.admin.entity.Admin;
import com.ewallet.admin.repository.AdminRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService
{
    private final AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public ResAdmin getAdmin(String id)throws Exception
    {

        var resAdmin = new ResAdmin();

        var admin = adminRepository.findById(Long.parseLong(id)).orElseThrow();        //Finding the entity from the table
        BeanUtils.copyProperties(admin,resAdmin); //copying properties to responseAdmin
        return resAdmin;
    }

    @Override
    public List<ResAdmin> getAllAdmin()
    {
        List<Admin> adminList = adminRepository.findAll();
        var resAdminList = new ArrayList<ResAdmin>();
        var resAdmin = new ResAdmin();

        for (Admin admin: adminList)
        {
            BeanUtils.copyProperties(resAdmin,admin);
            resAdminList.add(resAdmin);
        }
        return resAdminList;
    }

    @Override
    public void createAdmin(ReqAdmin reqAdmin)
    {
        var admin = new Admin();
        BeanUtils.copyProperties(reqAdmin,admin);
        adminRepository.save(admin);
    }

    @Override
    public void updateAdmin(String id, ReqAdmin reqAdmin)
    {
        var admin = adminRepository.findById(Long.parseLong(id)).orElseThrow();
        BeanUtils.copyProperties(reqAdmin,admin);
        adminRepository.save(admin);
    }

    @Override
    public void deleteAdmin(String id) throws Exception
    {
        adminRepository.deleteById(Long.parseLong(id));
    }
}
