package lukasz.nowogorski.api;

import lukasz.nowogorski.domain.model.UploadFile;
import lukasz.nowogorski.domain.service.DocumentHotelService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class HotelPhotoController {

    private final DocumentHotelService service;

    public HotelPhotoController(DocumentHotelService service) {
        this.service = service;
    }

    public UploadFile upload(@PathVariable MultipartFile file, @PathVariable Long id, @PathVariable String fileType)
    {
        String fileName = service.storePhoto(file,id,fileType);
        String download = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download")
                .path(fileName)
                .toUriString();

        return new UploadFile(fileName,download,file.getContentType(),file.getSize());
    }
}
