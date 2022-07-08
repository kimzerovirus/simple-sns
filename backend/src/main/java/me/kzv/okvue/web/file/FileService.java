package me.kzv.okvue.web.file;

import lombok.extern.log4j.Log4j2;
import me.kzv.okvue.web.file.dto.UploadResponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Log4j2
@Service
public class FileService {

    @Value("${upload.path}")
    private String uploadPath;

    public List<UploadResponseDto> uploadFile(MultipartFile[] uploadFiles){
        List<UploadResponseDto> responseDto = new ArrayList<>();

        for(MultipartFile uploadFile: uploadFiles){
            if(uploadFile.getContentType().startsWith("image") == false){
                log.warn("file is not image");
                return null;
            }

            String originFileName = uploadFile.getOriginalFilename();
            String fileName = originFileName.substring(originFileName.lastIndexOf("\\") + 1);
            log.info("filename = " + fileName);

            String folderPath = makeFolder();
            String uuid = UUID.randomUUID().toString();

            String saveFilename = uploadPath + File.separator + folderPath + File.separator + uuid + "_" + fileName;
            Path saveFilePath = Paths.get(saveFilename);

            try{
                uploadFile.transferTo(saveFilePath);
                responseDto.add(new UploadResponseDto(saveFilename, uuid, folderPath));
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        return responseDto;
    }

    private String makeFolder(){
        String str = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/DD"));
        String folderPath = str.replace("//", File.separator); // 연도 / 월 / 일로 폴더 생성

        File uploadPathFolder = new File(uploadPath, folderPath);
        if (uploadPathFolder.exists() == false) uploadPathFolder.mkdirs();

        return folderPath;
    }

}
