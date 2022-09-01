package com.common_service.attachment.service.definition;

import org.springframework.web.multipart.MultipartFile;

public interface AttachmentService
{
    void saveFile(MultipartFile file, String path);
    String uploadAttachment(MultipartFile file, String path);
    String uploadNidCard(MultipartFile file, String path);

}
