package com.example.community.controller;

import com.example.community.entity.Community;
import com.example.community.service.CommunityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/communities")
@RequiredArgsConstructor
public class CommunityController {
    private final CommunityService communityService;

    @PostMapping
    public ResponseEntity<Community> saveMember(@RequestBody Community community) {
        return  ResponseEntity.ok(communityService.save(community));
    }

    @GetMapping
    public ResponseEntity<List<Community>> getMembersByCommunityId() {
        return ResponseEntity.ok(communityService.getCommunities());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Community> getMemberById(@PathVariable Long id) {
        return ResponseEntity.ok(communityService.getCommunityById(id));
    }

    @GetMapping("/{id}/members")
    public ResponseEntity<?> getMemberByCommunityId(@PathVariable Long id) {
        return ResponseEntity.ok(communityService.getMembersByCommunity(id));
    }
}
