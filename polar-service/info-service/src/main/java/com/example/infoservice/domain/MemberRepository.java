package com.example.infoservice.domain;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository

public interface MemberRepository extends CrudRepository<Member, Long> {

    Optional<Member> findByMemberId(String memberId);
    @Modifying
    @Transactional
    @Query("DELETE FROM member WHERE memberId:memberId")
    void deleteByMemberId(String memberId);
    boolean existsByMemberId(String memberId);
}
