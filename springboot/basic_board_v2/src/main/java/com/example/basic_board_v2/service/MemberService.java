package com.example.basic_board_v2.service;

import com.example.basic_board_v2.mapper.MemberMapper;
import com.example.basic_board_v2.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;

    public void signUp(Member member) {
        memberMapper.saved(member);
    }

}
