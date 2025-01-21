package com.example.community.client;

import com.example.community.dto.MemberDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "member-service", url = "localhost:8090/api/members")
public interface MemberClient {
    @GetMapping("/community/{communityId}")
    List<MemberDto> getAllMembersByCommunityId(@PathVariable Long communityId);
}
