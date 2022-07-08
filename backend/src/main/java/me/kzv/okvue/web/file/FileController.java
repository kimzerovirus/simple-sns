package me.kzv.okvue.web.file;

import lombok.RequiredArgsConstructor;
import me.kzv.okvue.common.dto.ResponseDto;
import me.kzv.okvue.web.file.dto.UploadResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/file")
public class FileController {

    private final FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<ResponseDto> uploadFile(MultipartFile[] uploadFiles) {
        List<UploadResponseDto> result = fileService.uploadFile(uploadFiles);

        if (result == null) {
            return null;
        }else{
            return null;
        }
    }
}
