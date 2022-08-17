package com.ewallet.admin.service.implementation;

import com.ewallet.admin.dto.request.ReqAdminDto;
import com.ewallet.admin.dto.response.ResAdminDto;
import com.ewallet.admin.entity.Admin;
import com.ewallet.admin.enums.Gender;
import com.ewallet.admin.enums.Role;
import com.ewallet.admin.exception.NotFoundException;
import com.ewallet.admin.repository.AdminRepository;
import com.ewallet.admin.service.definition.AdminService;
import com.ewallet.admin.service.definition.AttachmentService;
import com.ewallet.admin.service.definition.NidCardService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AdminServiceImpl implements AdminService
{
    private final AdminRepository adminRepository;
    private final NidCardService nidCardService;
    private final AttachmentService attachmentService;

    public AdminServiceImpl(AdminRepository adminRepository, NidCardService nidCardService, AttachmentService attachmentService) {
        this.adminRepository = adminRepository;
        this.nidCardService = nidCardService;
        this.attachmentService = attachmentService;
    }

    @Override
    public ResAdminDto getAdmin(String id)
    {
        var admin = adminRepository.findById(Long.parseLong(id)).orElseThrow(() -> new NotFoundException("Not Found"));        //Finding the entity from the table

        return entityToDto(admin);
    }

    @Override
    public List<ResAdminDto> getAllAdmin()
    {
        List<Admin> adminList = adminRepository.findAll();
        var resAdminList = new ArrayList<ResAdminDto>();
        var resAdmin = new ResAdminDto();

        for (Admin admin: adminList)
        {
            resAdmin = entityToDto(admin);
            resAdminList.add(resAdmin);
        }
        return resAdminList;
    }

    @Override
    public void createAdmin(ReqAdminDto reqAdminDto)
    {
        var admin = dtoToEntity(reqAdminDto);
        var createdAt = LocalDateTime.now();
        admin.setCreatedAt(createdAt);

        adminRepository.save(admin);
    }

    @Override
    public void updateAdmin(String id, ReqAdminDto reqAdminDto)
    {
        var admin = adminRepository.findById(Long.parseLong(id)).orElseThrow(() -> new NotFoundException("Not Found"));

        var admin2 = dtoToEntity(reqAdminDto);
        admin2.setId(admin.getId());
        adminRepository.save(admin2);
    }

    @Override
    public void deleteAdmin(String id)
    {
        adminRepository.deleteById(Long.parseLong(id));
    }

    @Override
    public Admin dtoToEntity(ReqAdminDto reqAdminDto)
    {
        var nidCard = nidCardService.getNidCard(UUID.fromString(reqAdminDto.getNidNumber()));
        var profileImage = attachmentService.getAttachment(UUID.fromString(reqAdminDto.getProfileImagePath()));

        var admin = new Admin();
        BeanUtils.copyProperties(reqAdminDto,admin);
        var birthDate = LocalDate.parse(reqAdminDto.getBirthDate());
        admin.setBirthDate(birthDate);
        admin.setNidNumber(nidCard);
        admin.setProfileImage(profileImage);
        admin.setRole(Role.ROLE_ADMIN);
        admin.setGender(Gender.valueOf(reqAdminDto.getGender()));
        return admin;
    }

    @Override
    public ResAdminDto entityToDto(Admin admin)
    {


        var resAdminDto = new ResAdminDto();
        BeanUtils.copyProperties(admin,resAdminDto);
        resAdminDto.setBirthDate(admin.getBirthDate().toString());
        resAdminDto.setRole(Role.ROLE_ADMIN.toString());
        resAdminDto.setNidNumber(admin.getNidNumber().getNidNumber());
        resAdminDto.setProfileImagePath(admin.getProfileImage().getAttachmentPath());
        resAdminDto.setStatus(admin.getStatus().toString());
        resAdminDto.setGender(admin.getGender().toString());
        return resAdminDto;
    }
}
