package com.microservice.member.service;

import com.microservice.member.entity.Member;
import com.microservice.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService  implements IMemberService {
    final private MemberRepository memberRepository;

    @Override
    public List<Member> getMembers() {
        return (List<Member>)memberRepository.findAll();
    }

    @Override
    public Member getMember(Long id) {
        return memberRepository.findById(id).orElseThrow();
    }

    @Override
    public Member save(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public List<Member> getMembersByCommunityId(Long communityId) {
        return memberRepository.findByCommunityId(communityId);
    }
}
