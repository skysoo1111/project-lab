package com.skysoo.projectlab.dto;

import com.skysoo.projectlab.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class MemberDTO {
    private final Integer memberId;
    private final String loginId;
    private final String loginPw;
    private final String name;
    private final List<RoleDTO> roles;

    public static List<MemberDTO> from(Collection<Member> memberList) {
        return memberList.stream().map(MemberDTO::from).collect(Collectors.toList());
    }

    public static MemberDTO from(Member memberEntity) {
        return MemberDTO.builder()
                .memberId(memberEntity.getId())
                .loginId(memberEntity.getLoginId())
                .loginPw(memberEntity.getLoginPw())
                .name(memberEntity.getName())
                .roles(RoleDTO.from(memberEntity.getRoles()))
                .build();
    }
}
