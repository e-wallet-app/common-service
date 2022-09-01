package com.common_service.attachment.service.implementation;

import com.common_service.attachment.config.Properties;
import com.common_service.attachment.service.definition.AttachmentService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Service
public class AttachmentServiceImpl implements AttachmentService {
    @Override
    public void saveFile(MultipartFile file, String path) {
        Path rootLocation = Paths.get(Properties.WRITE_PATH + path);

        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            assert fileName != null;
            Path destinationFile = rootLocation.resolve(fileName);


            if (!destinationFile.toFile().exists()) {
                destinationFile.toFile().mkdirs();
            }

            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String uploadAttachment(MultipartFile file, String path)
    {
        saveFile(file,path);
        return ServletUriComponentsBuilder.fromCurrentContextPath().path("/attachment/").path(Objects.requireNonNull(file.getOriginalFilename())).toUriString();
    }

    @Override
    public String uploadNidCard(MultipartFile file, String path)
    {
        saveFile(file,path);
        return ServletUriComponentsBuilder.fromCurrentContextPath().path("/nid_card/").path(Objects.requireNonNull(file.getOriginalFilename())).toUriString();
    }
}
