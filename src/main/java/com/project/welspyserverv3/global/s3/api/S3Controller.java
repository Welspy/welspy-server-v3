package com.project.welspyserverv3.global.s3.api;

import com.project.welspyserverv3.global.common.dto.response.BaseResponseData;
import com.project.welspyserverv3.global.s3.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/s3")
@RequiredArgsConstructor
public class S3Controller {

    private final S3Service s3Service;

    @PostMapping
    public BaseResponseData<String> s3Upload(@RequestPart(value = "image", required = false) MultipartFile image){
        String profileImage = s3Service.upload(image);
        return BaseResponseData.ok(
                "이미지 업로드 성공",
                profileImage);
    }

}
