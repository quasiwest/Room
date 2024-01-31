package com.d209.childmade.book.dto;

import com.d209.childmade.book.entity.Book;

public class BookListDto {

    private int id;
    private String title;
    private String imageUrl;
    private String summary;
    private int maxNum;

    public BookListDto(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.imageUrl = book.getImageUrl();
        this.summary = book.getSummary();
        this.maxNum = book.getMaxNum();
    }
}
