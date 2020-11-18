package lukasz.nowogorski.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UploadFile {
    private String fileName;
    private String fileDownload;
    private String fileType;
    private Long size;
}
