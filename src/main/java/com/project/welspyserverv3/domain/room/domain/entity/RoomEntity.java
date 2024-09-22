package com.project.welspyserverv3.domain.room.domain.entity;

import com.project.welspyserverv3.domain.room.domain.enums.Category;
import com.project.welspyserverv3.domain.room.domain.enums.RoomType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "tb_room")
@NoArgsConstructor
@SuperBuilder
public class RoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)

    private String description;

    @Column(nullable = false)

    private Long goalMoney;

    @Column(nullable = false)

    private int memberLimit;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RoomType roomType;

}
