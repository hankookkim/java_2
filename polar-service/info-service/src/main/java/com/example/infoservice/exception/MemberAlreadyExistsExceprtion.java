package com.example.infoservice.exception;

public class MemberAlreadyExistsExceprtion extends RuntimeException {
    public MemberAlreadyExistsExceprtion(String memberId) {
        super("Member with id " + memberId + " already exists");
    }
}
