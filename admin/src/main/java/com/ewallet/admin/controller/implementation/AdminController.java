package com.ewallet.admin.controller.implementation;

import com.ewallet.admin.controller.definition.IAdminController;
import com.ewallet.admin.dto.request.ReqAdminDto;
import com.ewallet.admin.dto.response.ResAdminDto;
import com.ewallet.admin.service.definition.IAdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController implements IAdminController {

    private final IAdminService iAdminService;

    public AdminController(IAdminService IAdminService) {
        this.iAdminService = IAdminService;
    }

    @Override
    public ResponseEntity<String> createAdmin(ReqAdminDto reqAdminDto)
    {
        iAdminService.createAdmin(reqAdminDto);
        return new  ResponseEntity<>("Successfully created admin", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String > updateAdmin(String id, ReqAdminDto reqAdminDto)
    {
        iAdminService.updateAdmin(id, reqAdminDto);

        return ResponseEntity.ok("Admin updated");
    }


    @Override
    public ResponseEntity<String > deleteAdmin(String id) throws Exception {
        iAdminService.deleteAdmin(id);
        return ResponseEntity.ok("Admin account deleted");
    }

    @Override
    public ResponseEntity<List<ResAdminDto>> getAdminList()
    {
        var resAdminDtoList = iAdminService.getAllAdmin();
        return ResponseEntity.ok(resAdminDtoList);
    }

    @Override
    public ResponseEntity<ResAdminDto> getAdmin(String id) throws Exception{
        var resAdminDto = iAdminService.getAdmin(id);
        return ResponseEntity.ok(resAdminDto);
    }
}
