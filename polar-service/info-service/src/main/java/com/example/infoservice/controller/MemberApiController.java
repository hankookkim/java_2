package com.example.infoservice.controller;


import com.example.infoservice.domain.Member;

import com.example.infoservice.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberApiController {

    private final MemberService memberService;


    @GetMapping
    public Iterable<Member> getMembers() {
        return memberService.viewMemberList();
    }

    @GetMapping("/{memberId}")
    public Member getMember(@PathVariable String memberId) {
        return memberService.viewMember(memberId);
    }

    @PostMapping
    public Member addMember(@Valid @RequestBody Member member) {
        return memberService.addMember(member);
    }
    @PutMapping("/{memberId}")
    public Member updateMember(@PathVariable String memberId, @Valid @RequestBody Member member) {
        return memberService.editMemberDetails(memberId, member);
    }
    @DeleteMapping("/{memberId}")
    public void deleteMember(@PathVariable String memberId) {
        memberService.removeMember(memberId);
    }

}
