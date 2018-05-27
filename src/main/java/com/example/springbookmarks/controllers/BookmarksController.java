package com.example.springbookmarks.controllers;

import com.example.springbookmarks.repositories.BookmarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.springbookmarks.models.Bookmark;

import java.util.Optional;

@RestController
public class BookmarksController{

    @Autowired
    private BookmarkRepository bookmarkRepository;

    @GetMapping("/bookmarks")
    public Iterable<Bookmark> findAllBookmarks() {
        return bookmarkRepository.findAll();
    }

    @GetMapping("/users/{userId}")
    public Optional<Bookmark> findUserById(@PathVariable Long bookmarkId) {
        return bookmarkRepository.findById(bookmarkId);
    }

}