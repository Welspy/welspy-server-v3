package com.project.welspyserverv3.domain.s3.api;

import com.project.welspyserverv3.domain.s3.service.S3Service;
import com.project.welspyserverv3.global.common.dto.response.BaseResponse;
import com.project.welspyserverv3.global.common.dto.response.BaseResponseData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/s3")
@RequiredArgsConstructor
@Tag(name = "이미지 API")
public class S3Controller {

    private final S3Service s3Service;

    @PostMapping
    @Operation(summary = "이미지 업로드")
    public BaseResponseData<String> s3Upload(@RequestPart(value = "image", required = false) MultipartFile image, HttpServletRequest http) {
        System.out.println("/s3 POST "+http.getRemoteAddr());
        String profileImage = s3Service.upload(image);
        return BaseResponseData.ok(
                "이미지 업로드 성공",
                profileImage);
    }

    @DeleteMapping
    @Operation(summary = "이미지 삭제")
    public BaseResponse s3Delete(@RequestParam String imageUrl, HttpServletRequest http) {
        System.out.println("/s3 DELETE "+http.getRemoteAddr());
        s3Service.deleteImageFromS3(imageUrl);
        return BaseResponse.ok("이미지 삭제 성공");
    }

}
