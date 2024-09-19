package com.project.welspyserverv3.domain.user.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum VisionType {
    PUBLIC("공개"),
    PRIVATE("비공개");

    private final String key;
}
