package com.example.basic_board_review.service;


import com.example.basic_board_review.mapper.MemberMapper;
import com.example.basic_board_review.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;

    public void signUp(Member member) {
        memberMapper.insertMember(member);
    }
}
