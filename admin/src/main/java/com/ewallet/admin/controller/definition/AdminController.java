package com.ewallet.admin.controller.definition;

import com.ewallet.admin.dto.request.ReqAdminDto;
import com.ewallet.admin.dto.response.ResAdminDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("${cross.origin}")
@RequestMapping("/api/v1/admin")
public interface AdminController
{
    @PostMapping("/")
    ResponseEntity<String> createAdmin(@RequestBody ReqAdminDto reqAdminDto);

    @PutMapping("/{id}")
    ResponseEntity<?> updateAdmin(@PathVariable String id, @RequestBody ReqAdminDto reqAdminDto);

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteAdmin(@PathVariable("id") String id) throws Exception;

    @GetMapping("/")
    ResponseEntity<List<ResAdminDto>> getAdminList();

    @GetMapping("/{id}")
    ResponseEntity<ResAdminDto> getAdmin(@PathVariable String id) throws Exception;
}
