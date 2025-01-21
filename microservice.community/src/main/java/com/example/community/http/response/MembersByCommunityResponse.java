package com.example.community.http.response;

import com.example.community.dto.MemberDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MembersByCommunityResponse {
    private String name;
    private String description;
    private List<MemberDto> members;
}
