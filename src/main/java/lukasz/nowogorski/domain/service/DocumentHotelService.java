package lukasz.nowogorski.domain.service;

import lukasz.nowogorski.domain.model.HotelPhoto;
import lukasz.nowogorski.exception.DocumentPhotoException;
import lukasz.nowogorski.infrastructure.postgres.HotelPhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Service
public class DocumentHotelService {

    private final Path locationDocument;
    private HotelPhotoRepository repository;

    @Autowired
    public DocumentHotelService(Path locationDocument) {
        this.locationDocument = locationDocument;
    }

    public DocumentHotelService(HotelPhoto fileHotel) {
        this.locationDocument = Paths.get(fileHotel.getUpload())
                .toAbsolutePath().normalize();

        try {
            Files.createDirectories(locationDocument);
        } catch (IOException e) {
            throw new DocumentPhotoException("Couldn't create directory for upload file",e);
        }
    }

    public String storePhoto(MultipartFile multipartFile,Long id,String typePhoto)
    {
        String originalFileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        String fileName = "";
        try
        {

        if(originalFileName.contains(".."))
        {
            throw new DocumentPhotoException("Sorry! Filename contains invalid path sequence "+originalFileName);
        }
        String fileNameEnds = "";
        try {
            fileNameEnds = originalFileName.substring(originalFileName.lastIndexOf("."));
        }
        catch (Exception e)
        {
            fileNameEnds = "";
        }
        fileName = id + typePhoto + fileNameEnds;
        Path targetLocation = this.locationDocument.resolve(fileName);

            Files.copy(multipartFile.getInputStream(),targetLocation, StandardCopyOption.REPLACE_EXISTING);


        HotelPhoto documentHotel = repository.checkPhotoById(id,typePhoto);

        if(documentHotel != null)
        {
            documentHotel.setFormat(multipartFile.getContentType());
            documentHotel.setFileName(fileName);
            repository.save(documentHotel);
        }
        else
        {
            HotelPhoto docHotel = new HotelPhoto();
            docHotel.setId(id);
            docHotel.setFileName(fileName);
            docHotel.setDocumentType(typePhoto);
            docHotel.setFormat(multipartFile.getContentType());
            repository.save(docHotel);

        }
        return fileName;
        } catch (IOException e) {
            throw new DocumentPhotoException("Could not store file " + fileName + ". Please try again!", e);
        }
    }
    public Resource loadFileAsResource(String fileName) throws Exception {
        try {
            Path filePath = this.locationDocument.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new FileNotFoundException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new FileNotFoundException("File not found " + fileName);
        }
    }
    public String getDocumentName(Long id, String type) {
        return repository.getUploadPhotoPath(id, type);
    }
}
