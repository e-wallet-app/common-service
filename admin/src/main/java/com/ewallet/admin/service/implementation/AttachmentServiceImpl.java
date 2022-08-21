package com.ewallet.admin.service.implementation;

import com.ewallet.admin.config.Properties;
import com.ewallet.admin.entity.Attachment;
import com.ewallet.admin.exceptions.NotFoundException;
import com.ewallet.admin.repository.AttachmentRepository;
import com.ewallet.admin.service.definition.AttachmentService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
@Transactional
public class AttachmentServiceImpl implements AttachmentService
{
    private final AttachmentRepository attachmentRepository;

    public AttachmentServiceImpl(AttachmentRepository attachmentRepository)
    {
        this.attachmentRepository = attachmentRepository;
    }


    @Override
    public Attachment getAttachment(UUID id)
    {
        var attachment =  attachmentRepository.findById(id).orElseThrow(() -> new NotFoundException("Attachment not found"));
        return attachment;
    }

    @Override
    public Attachment uploadAttachment(MultipartFile file, String path) throws IOException
    {
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

                var attachment = new Attachment();
                attachment.setAttachmentName(fileName);
                attachment.setAttachmentPath(path + fileName);
                attachment.setAttachmentType(file.getContentType());

                return attachment;
            }catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        return null;
    }
}
