package com.example.catalogservice.exception;

public class BookAlreadyExistsException extends RuntimeException {
  public BookAlreadyExistsException(String isbn) {
    super("Book already exists: " + isbn);
  }
}