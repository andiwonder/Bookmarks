package com.example.springbookmarks.repositories;

import com.example.springbookmarks.models.Bookmark;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookmarkRepository extends PagingAndSortingRepository<Bookmark, Long> {

}