package com.ewallet.admin.controller.definition;

import com.ewallet.admin.dto.request.RequestAdminDto;
import com.ewallet.admin.dto.response.ResponseAdminDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin("${http://localhost:4200}")
@RequestMapping("/api/v1/admin")
public interface AdminController
{
    @PostMapping("/")
    ResponseEntity<String> createAdmin(@RequestBody RequestAdminDto requestAdminDto) throws IOException;

    @PutMapping("/{id}")
    ResponseEntity<?> updateAdmin(@PathVariable("id") String id, @RequestBody RequestAdminDto requestAdminDto) throws IOException;

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteAdmin(@PathVariable("id") String id) throws Exception;

    @GetMapping("/")
    ResponseEntity<List<ResponseAdminDto>> getAdminList();

    @GetMapping("/{id}")
    ResponseEntity<ResponseAdminDto> getAdmin(@PathVariable("id") String id) throws Exception;
}
