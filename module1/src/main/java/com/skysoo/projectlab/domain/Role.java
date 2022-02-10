package com.skysoo.projectlab.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "`ROLE`")
public class Role {
    @Id
    @Column(name = "`ROLE_ID`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "`ROLE`")
    private String role;

    // 연관 관계 주인
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "`MEMBER_ID`")
    private Member member;
}
