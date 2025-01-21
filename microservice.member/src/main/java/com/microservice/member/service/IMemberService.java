package com.microservice.member.service;

import com.microservice.member.entity.Member;

import java.util.List;

public interface IMemberService {
    List<Member> getMembers();
    Member getMember(Long id);
    Member save(Member member);
    List<Member> getMembersByCommunityId(Long communityId);
}
