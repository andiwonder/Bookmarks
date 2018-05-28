package com.example.springbookmarks.repositories;

import com.example.springbookmarks.models.Tag;
import org.springframework.data.repository.CrudRepository;


public interface TagRepository extends CrudRepository<Tag, Long> { }
