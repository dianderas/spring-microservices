package com.microservice.member.controller;

import com.microservice.member.entity.Member;
import com.microservice.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<Member> saveMember(@RequestBody Member member) {
        return  ResponseEntity.ok(memberService.save(member));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable Long id) {
        return ResponseEntity.ok(memberService.getMember(id));
    }

    @GetMapping("/community/{communityId}")
    public ResponseEntity<List<Member>> getMembersByCommunityId(@PathVariable Long communityId) {
        return ResponseEntity.ok(memberService.getMembersByCommunityId(communityId));
    }
}
