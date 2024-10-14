package com.project.welspyserverv3.global.ai.client.dto;

import com.project.welspyserverv3.domain.room.domain.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataResponse {

    private Long id;
    private Long challengeId;
    private String userEmail;
    private Category category;
    private LocalDateTime startTime;

}
