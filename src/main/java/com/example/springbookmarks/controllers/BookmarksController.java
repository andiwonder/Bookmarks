package com.example.springbookmarks.controllers;

import com.example.springbookmarks.repositories.BookmarkRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.springbookmarks.models.Bookmark;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@RestController
public class BookmarksController{

    @Autowired
    private BookmarkRepository bookmarkRepository;

    @GetMapping("/bookmarks")
    public Iterable<Bookmark> findAllBookmarks() {
        return bookmarkRepository.findAll();
    }

    @GetMapping("/loadBookmarks")
    public HttpStatus loadBookmarks() {
        File input = new File("src/main/resources/static/bookmarks.html");
        try {
            Document doc = Jsoup.parse(input, "UTF-8");
            Elements datatables = doc.getElementsByTag("DT");
            for (Element datatable : datatables) {
                Elements link = datatable.getElementsByTag("a");
                String linkHref = link.attr("href");
                String linkText = link.text();
                try {
                    if((linkText != null && linkText != "" && linkText.length() < 80)
                            && (linkHref != null && linkHref != "" && linkHref.length() < 300)){
                        // System.out.println(linkText.length());
                        bookmarkRepository.save(new Bookmark(linkText, linkHref));
                    }
                } catch (NullPointerException ex){
                    ex.printStackTrace();
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            return HttpStatus.OK;
        }
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