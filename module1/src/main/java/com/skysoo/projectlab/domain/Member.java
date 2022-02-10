package com.skysoo.projectlab.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "`MEMBER`")
public class Member {
    @Id
    @Column(name = "`MEMBER_ID`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "`LOGIN_ID`")
    private String loginId;
    @Column(name = "`LOGIN_PW`")
    private String loginPw;
    @Column(name = "`NAME`")
    private String name;

    // 양방향 매핑
    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Role> roles;
}
