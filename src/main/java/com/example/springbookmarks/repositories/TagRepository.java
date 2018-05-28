package com.example.springbookmarks.repositories;

import com.example.springbookmarks.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> { }
