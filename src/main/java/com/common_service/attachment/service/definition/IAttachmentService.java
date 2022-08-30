package com.common_service.attachment.service.definition;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public interface IAttachmentService
{
    ResponseEntity<String> uploadAttachment(CommonsMultipartFile file, String path);

}
