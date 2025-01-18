package com.simplepay.member.adapter.out.persistence;

import com.simplepay.member.domain.Member;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {

    public Member mapToDomainEntity(MemberJpaEntity jpaEntity) {
        return Member.generateMember(
            jpaEntity.getId(),
            jpaEntity.getName(),
            jpaEntity.getEmail(),
            jpaEntity.getAddress(),
            jpaEntity.isValid()
        );
    }
}
