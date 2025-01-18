package com.simplepay.member.adapter.out.persistence;

import com.simplepay.common.annotation.PersistenceAdapter;
import com.simplepay.member.application.port.out.FindMemberPort;
import com.simplepay.member.application.port.out.RegisterMemberPort;
import com.simplepay.member.application.port.out.UpdateMemberPort;
import com.simplepay.member.domain.Member;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
public class MemberPersistenceAdapter
    implements RegisterMemberPort, FindMemberPort, UpdateMemberPort {

    private final MemberSpringDataRepository memberRepository;
    private final MemberMapper memberMapper;

    @Override
    public void createMember(
        String name,
        String email,
        String address,
        boolean isValid
    ) {
        memberRepository.save(
            new MemberJpaEntity(
                name, email, address, isValid
            )
        );
    }

    @Override
    public Member findById(Long id) {
        var memberJpaEntity = memberRepository.findById(id)
            .orElseThrow(RuntimeException::new);

        return memberMapper.mapToDomainEntity(memberJpaEntity);
    }

    @Override
    public Member findByEmail(String email) {
        var memberJpaEntity = memberRepository.findByEmail(email)
            .orElseThrow(RuntimeException::new);

        return memberMapper.mapToDomainEntity(memberJpaEntity);
    }

    @Override
    public Member updateMember(
        Long memberId,
        String name,
        String email,
        String address,
        boolean isValid
    ) {
        var memberJpaEntity = memberRepository.findById(memberId)
            .orElseThrow(RuntimeException::new);

        memberJpaEntity.setName(name);
        memberJpaEntity.setEmail(email);
        memberJpaEntity.setAddress(address);
        memberJpaEntity.setValid(isValid);

        var updatedMember = memberRepository.save(memberJpaEntity);

        return memberMapper.mapToDomainEntity(updatedMember);
    }
}
