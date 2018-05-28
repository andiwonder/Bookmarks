package com.example.springbookmarks.repositories;

import com.example.springbookmarks.models.Tag;
// TODO figure out the right repo to use
import org.springframework.data.repository.CrudRepository;

public interface TagRepository extends CrudRepository<Tag, Long> { }
