package com.example.basic_board_review.mapper;


import com.example.basic_board_review.model.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    void insertMember(Member member);
    Member selectMemberById(String userId);
}
