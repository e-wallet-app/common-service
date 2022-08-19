package com.ewallet.admin.controller.implementation;

import com.ewallet.admin.controller.definition.AdminController;
import com.ewallet.admin.dto.request.RequestAdminDto;
import com.ewallet.admin.dto.response.ResponseAdminDto;
import com.ewallet.admin.service.definition.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class AdminControllerImpl implements AdminController {

    private final AdminService adminService;

    public AdminControllerImpl(AdminService AdminService) {
        this.adminService = AdminService;
    }

    @Override
    public ResponseEntity<String> createAdmin(RequestAdminDto requestAdminDto) throws IOException {
        adminService.createAdmin(requestAdminDto);
        return new  ResponseEntity<>("Successfully created admin", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String > updateAdmin(String id, RequestAdminDto requestAdminDto) throws IOException {
        adminService.updateAdmin(id, requestAdminDto);

        return ResponseEntity.ok("Admin updated");
    }


    @Override
    public ResponseEntity<String > deleteAdmin(String id) throws Exception {
        adminService.deleteAdmin(id);
        return ResponseEntity.ok("Admin account deleted");
    }

    @Override
    public ResponseEntity<List<ResponseAdminDto>> getAdminList()
    {
        var resAdminDtoList = adminService.getAllAdmin();
        return ResponseEntity.ok(resAdminDtoList);
    }

    @Override
    public ResponseEntity<ResponseAdminDto> getAdmin(String id) throws Exception{
        var resAdminDto = adminService.getAdmin(id);
        return ResponseEntity.ok(resAdminDto);
    }
}
