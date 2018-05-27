package com.example.springbookmarks.repositories;

import com.example.springbookmarks.models.Bookmark;
import org.springframework.data.repository.CrudRepository;

public interface BookmarkRepository extends CrudRepository<Bookmark, Long> {

}