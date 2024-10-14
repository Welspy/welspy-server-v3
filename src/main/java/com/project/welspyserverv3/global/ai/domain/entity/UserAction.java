package com.project.welspyserverv3.global.ai.domain.entity;

import com.project.welspyserverv3.domain.room.domain.enums.Category;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.joda.time.DateTime;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "user_action")
public class UserAction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long challengeId;

    @Column(nullable = false)
    private String userEmail;

    @Column(nullable = false)
    private Category category;

    @Column(nullable = false)
    private DateTime startTime;

}
