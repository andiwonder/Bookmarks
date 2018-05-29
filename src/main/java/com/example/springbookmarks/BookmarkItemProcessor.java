package com.example.springbookmarks;

import com.example.springbookmarks.models.Bookmark;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;

public class BookmarkItemProcessor implements ItemProcessor<Bookmark, Bookmark> {

    private static final Logger log = LoggerFactory.getLogger(BookmarkItemProcessor.class);

    @Override
    public Bookmark process(final Bookmark bookmark) throws Exception {
        final String title = bookmark.getTitle().toUpperCase();
        final String description = bookmark.getDescription().toUpperCase();

        final Bookmark transformedBookmark = new Bookmark(title, description);

        log.info("Converting (" + bookmark + ") into (" + bookmark + ")");

        return transformedBookmark;
    }

}
