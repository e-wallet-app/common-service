package com.common_service.attachment.service.implementation;

import com.common_service.attachment.config.Properties;
import com.common_service.attachment.service.definition.IAttachmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import javax.transaction.Transactional;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Service
@Transactional
public class AttachmentServiceImpl implements IAttachmentService
{
    @Override
    public ResponseEntity<String> uploadAttachment(CommonsMultipartFile file, String path) {
        Path rootLocation = Paths.get(Properties.WRITE_PATH + path);

        if(!file.isEmpty())
        {
            String fileName = file.getOriginalFilename();
            assert fileName != null;
            Path destinationFile = rootLocation.resolve(fileName);

            if(!destinationFile.toFile().exists())
            {
                destinationFile.toFile().mkdirs();
            }

            try (InputStream inputStream = file.getInputStream())
            {
                Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);

                if(Objects.equals(path, Properties.Attachment_FOLDER))
                {
                    return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/attachment/").path(Objects.requireNonNull(file.getOriginalFilename())).toUriString());
                }else {
                    return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/nidCard/").path(Objects.requireNonNull(file.getOriginalFilename())).toUriString());
                }

            }catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        return null;
    }
}
