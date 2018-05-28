package com.example.springbookmarks.controllers;

import com.example.springbookmarks.repositories.BookmarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.springbookmarks.models.Bookmark;

import java.util.Optional;

@RestController
public class BookmarksController{

    @Autowired
    private BookmarkRepository bookmarkRepository;

    @CrossOrigin
    @GetMapping("/bookmarks")
    public Iterable<Bookmark> findAllBookmarks() {
        return bookmarkRepository.findAll();
    }

    @GetMapping("/bookmarks/{bookmarkId}")
    public Optional<Bookmark> findBookmarkById(@PathVariable Long bookmarkId) {
        return bookmarkRepository.findById(bookmarkId);
    }

    @DeleteMapping("/bookmarks/{bookmarkId}")
    public HttpStatus deleteBookmarkById(@PathVariable Long bookmarkId) {
        bookmarkRepository.deleteById(bookmarkId);
        return HttpStatus.OK;
    }

    @PostMapping("/bookmarks")
    public Bookmark createNewBookmark(@RequestBody Bookmark newBookmark) {
        return bookmarkRepository.save(newBookmark);
    }

    @PutMapping("/bookmarks/{bookmarkId}")
    public Bookmark updateBookmarkById(@PathVariable Long bookmarkId, @RequestBody Bookmark bookmarkRequest) {

        Bookmark bookmarkFromDb = bookmarkRepository.findById(bookmarkId).get();

        bookmarkFromDb.setTitle(bookmarkRequest.getTitle());
        bookmarkFromDb.setDescription(bookmarkRequest.getDescription());
        bookmarkFromDb.setUrl(bookmarkRequest.getUrl());

        return bookmarkRepository.save(bookmarkFromDb);
    }



}