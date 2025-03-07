package com.example.basic_board_v2.mapper;


import com.example.basic_board_v2.model.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    void saved(Member member);
    Member findByUserId(String userId);
}
