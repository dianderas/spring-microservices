package com.example.community.service;

import com.example.community.entity.Community;
import com.example.community.http.response.MembersByCommunityResponse;

import java.util.List;

public interface ICommunityService {
    List<Community> getCommunities();
    Community getCommunityById(Long id);
    Community save(Community community);
    MembersByCommunityResponse getMembersByCommunity(Long communityId);
}
