package com.example.infoservice.service;


import com.example.infoservice.domain.Member;
import com.example.infoservice.domain.MemberRepository;
import com.example.infoservice.exception.MemberAlreadyExistsExceprtion;
import com.example.infoservice.exception.MemberNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;


    public Iterable<Member> viewMemberList() {
        return memberRepository.findAll();
    }


    public Member viewMember(String memberId) {
        return memberRepository.findByMemberId(memberId)
                .orElseThrow(() -> new MemberNotFoundException(memberId));
    }

    public Member addMember(Member member) {
        if(memberRepository.existsByMemberId(member.memberId())){
            throw new MemberAlreadyExistsExceprtion(member.memberId());
        }
        return memberRepository.save(member);
    }
    public void removeMember(String memberId) {
        memberRepository.deleteByMemberId(memberId);
    }

    public Member editMemberDetails(String memberId, Member member) {
        return memberRepository.findByMemberId(memberId)
                .map(
                        existingMember->{
                            Member.builder()
                                    .id(existingMember.id())
                                    .memberId(memberId)
                                    .memberName(member.memberName())
                                    .phoneNumber(member.phoneNumber())
                                    .createAt(existingMember.createAt())
                                    .lastModifiedAt(existingMember.lastModifiedAt())
                                    .build();
                            return memberRepository.save(existingMember);

                        }

                ).orElseGet(()->memberRepository.save(member));
    }
}
