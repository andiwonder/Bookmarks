package com.example.springbookmarks.models;

import lombok.*;
import javax.persistence.*;

@Data
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity @Table(name = "TAGS")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TYPE")
    private String type;

    @ManyToOne
    @JoinColumn(name = "bookmark_id")
    private Bookmark bookmark;

    public Tag(String type, Bookmark bookmark) {
        this.type = type;
        this.bookmark = bookmark;
    }
}
