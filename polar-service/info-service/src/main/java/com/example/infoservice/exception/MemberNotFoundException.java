package com.example.infoservice.exception;

public class MemberNotFoundException extends RuntimeException {
    public MemberNotFoundException(String memberId) {
        super("Member with id " + memberId + " does not exist");
    }
}
