package com.project.welspyserverv3.domain.room.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor
@Table(name = "tb_member_list")
public class MemberListEntity {

    @Id
    private Long idx;

    @Column(nullable = false)
    private Long roomId;

    @Column(nullable = false)
    private String email;

    private Long balance;

    private String title;

    private String description;

    private Long goalMoney;

}
