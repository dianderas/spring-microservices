package com.example.community.service;

import com.example.community.client.MemberClient;
import com.example.community.dto.MemberDto;
import com.example.community.entity.Community;
import com.example.community.http.response.MembersByCommunityResponse;
import com.example.community.repository.CommunityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommunityService implements ICommunityService {

    final private CommunityRepository communityRepository;
    private final MemberClient memberClient;

    @Override
    public List<Community> getCommunities() {
        return (List<Community>)communityRepository.findAll();
    }

    @Override
    public Community getCommunityById(Long id) {
        return communityRepository.findById(id).orElseThrow();
    }

    @Override
    public Community save(Community community) {
        return communityRepository.save(community);
    }

    @Override
    public MembersByCommunityResponse getMembersByCommunity(Long communityId) {
        Community community = communityRepository.findById(communityId)
                .orElse(Community.builder().build()); // Todo: check later

        List<MemberDto> memberDtosList = memberClient.getAllMembersByCommunityId(communityId);

        return MembersByCommunityResponse.builder()
                .name(community.getName())
                .description(community.getDescription())
                .members(memberDtosList)
                .build();
    }
}
