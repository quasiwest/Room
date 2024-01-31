package com.d209.childmade.book.controller;

import com.d209.childmade._common.response.SuccessResponse;
import com.d209.childmade._common.response.SuccessType;
import com.d209.childmade.book.dto.BookListDto;
import com.d209.childmade.book.dto.scriptListDto;
import com.d209.childmade.book.entity.Book;
import com.d209.childmade.book.repository.BookRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookRepository bookRepository;

    @GetMapping("/")
    public SuccessResponse<Page<BookListDto>> bookList(Pageable pageable) {
        Page<Book> page = bookRepository.findAll(pageable);
        return SuccessResponse.of(SuccessType.BOOK_LIST_SUCCESSFULLY,page.map(BookListDto::new));
    }
    @GetMapping("/{{book-id}")
    public SuccessResponse<List<scriptListDto>> scriptList(Pageable pageable) {
        Page<Book> page = bookRepository.findAll(pageable);
        return SuccessResponse.of(SuccessType.BOOK_LIST_SUCCESSFULLY,page.map(BookListDto::new));
    }



}
