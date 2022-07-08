package me.kzv.okvue.web.file.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UploadResponseDto implements Serializable {
    private String fileName;
    private String uuid;
    private String folderPath;

    public String getImageURL(){
        try{
            return URLEncoder.encode(folderPath + "/" + uuid + "-" + fileName, "UTF-8");
        }catch(UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return "";
    }
}