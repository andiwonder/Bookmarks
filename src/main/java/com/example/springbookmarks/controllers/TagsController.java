package com.example.springbookmarks.controllers;

import com.example.springbookmarks.models.Tag;
import com.example.springbookmarks.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TagsController {
    @Autowired
    private TagRepository tagRepository;

    @GetMapping("/tags")
    public Iterable<Tag> findAllTags() { return tagRepository.findAll(); }

    

}
