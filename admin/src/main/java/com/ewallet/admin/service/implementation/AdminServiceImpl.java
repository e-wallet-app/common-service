package com.ewallet.admin.service.implementation;

import com.ewallet.admin.dto.request.RequestAdminDto;
import com.ewallet.admin.dto.response.ResponseAdminDto;
import com.ewallet.admin.entity.Admin;
import com.ewallet.admin.enums.Gender;
import com.ewallet.admin.enums.Role;
import com.ewallet.admin.exceptions.NotFoundException;
import com.ewallet.admin.repository.AdminRepository;
import com.ewallet.admin.service.definition.AdminService;
import com.ewallet.admin.service.definition.AttachmentService;
import com.ewallet.admin.service.definition.NidCardService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
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
    public ResponseAdminDto getAdmin(String id)
    {
        var admin = adminRepository.findById(UUID.fromString(id)).orElseThrow(() -> new NotFoundException("Not Found"));        //Finding the entity from the table

        return entityToDto(admin);
    }

    @Override
    public List<ResponseAdminDto> getAllAdmin()
    {
        List<Admin> adminList = adminRepository.findAll();
        var resAdminList = new ArrayList<ResponseAdminDto>();
        var resAdmin = new ResponseAdminDto();

        for (Admin admin: adminList)
        {
            resAdmin = entityToDto(admin);
            resAdminList.add(resAdmin);
        }
        return resAdminList;
    }

    @Override
    public void createAdmin(RequestAdminDto requestAdminDto) throws IOException {
        var admin = dtoToEntity(requestAdminDto);
        var createdAt = LocalDateTime.now();
        admin.setCreatedAt(createdAt);

        adminRepository.save(admin);
    }

    @Override
    public void updateAdmin(String id, RequestAdminDto requestAdminDto) throws IOException {
        var admin = adminRepository.findById(UUID.fromString(id)).orElseThrow(() -> new NotFoundException("Not Found"));

        var admin2 = dtoToEntity(requestAdminDto);
        admin2.setId(admin.getId());
        admin2.setCreatedAt(admin.getCreatedAt());
        admin2.setStatus(admin.getStatus());
        adminRepository.save(admin2);
    }

    @Override
    public void deleteAdmin(String id)
    {
        adminRepository.deleteById(UUID.fromString(id));
    }

    @Override
    public Admin dtoToEntity(RequestAdminDto requestAdminDto) throws IOException {
//        var nidCard = nidCardService.getNidCard(UUID.fromString(requestAdminDto.getNidNumber()));
//        var profileImage = attachmentService.uploadAttachment(file, Properties.Attachment_FOLDER);
//        var nidCardImage = attachmentService.uploadAttachment(file2, Properties.NID_CARD_FOLDER);

        var admin = new Admin();
        BeanUtils.copyProperties(requestAdminDto,admin);
        var birthDate = LocalDate.parse(requestAdminDto.getBirthDate());
        admin.setBirthDate(birthDate);
//        admin.setNidNumber(nidCard);
//        admin.setProfileImage(profileImage);
        admin.setRole(Role.ROLE_ADMIN);
        admin.setGender(Gender.valueOf(requestAdminDto.getGender()));
        return admin;
    }

    @Override
    public ResponseAdminDto entityToDto(Admin admin)
    {


        var resAdminDto = new ResponseAdminDto();
        BeanUtils.copyProperties(admin,resAdminDto);
        resAdminDto.setId(admin.getId().toString());
        resAdminDto.setBirthDate(admin.getBirthDate().toString());
        resAdminDto.setRole(Role.ROLE_ADMIN.toString());
        resAdminDto.setCreatedAt(admin.getCreatedAt().toString());
//        resAdminDto.setNidNumber(admin.getNidNumber().getNidNumber());
//        resAdminDto.setProfileImagePath(admin.getProfileImage().getAttachmentPath());
        resAdminDto.setStatus(admin.getStatus().toString());
        resAdminDto.setGender(admin.getGender().toString());
        return resAdminDto;
    }
}
