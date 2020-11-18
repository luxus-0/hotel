package lukasz.nowogorski.infrastructure.postgres;

import lukasz.nowogorski.domain.model.HotelPhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HotelPhotoRepository extends JpaRepository<HotelPhoto,Long> {

    @Query("Select p from HotelPhoto p where id = ?1 and documentType = ?2")
    HotelPhoto checkPhotoById(Long id, String type);

    @Query("Select fileName from HotelPhoto p where id = ?1 and documentType = ?2")
    String getUploadPhotoPath(Long id, String type);
}
