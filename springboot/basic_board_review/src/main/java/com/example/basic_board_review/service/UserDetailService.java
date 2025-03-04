package com.example.basic_board_review.service;


import com.example.basic_board_review.config.security.CustomUserDetails;
import com.example.basic_board_review.mapper.MemberMapper;
import com.example.basic_board_review.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.CachingUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {

    private final MemberMapper memberMapper;

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("loadUserByUsername"+username);
        Member member = memberMapper.selectMemberById(username);

        if (member == null) {
            throw new UsernameNotFoundException(username);
        }
        return CustomUserDetails.builder()
                .member(member)
                .build();
    }
}
