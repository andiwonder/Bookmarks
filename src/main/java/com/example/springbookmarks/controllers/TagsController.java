package com.example.springbookmarks.controllers;

import com.example.springbookmarks.models.Tag;
import com.example.springbookmarks.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class TagsController {
    @Autowired
    private TagRepository tagRepository;

    @GetMapping("/tags")
    public Iterable<Tag> findAllTags() { return tagRepository.findAll(); }

    @GetMapping("/tags/{tagId}")
    public Optional<Tag> findTagById(@PathVariable long tagId){
        return tagRepository.findById(tagId);
    }

    @DeleteMapping("/tags/{tagId}")
    public HttpStatus deleteTagById(@PathVariable Long tagId) {
        tagRepository.deleteById(tagId);
        return HttpStatus.OK;
    }

    @PostMapping("/tags")
    public Tag createNewTag(@RequestBody Tag newTag){
        return tagRepository.save(newTag);
    }
}
