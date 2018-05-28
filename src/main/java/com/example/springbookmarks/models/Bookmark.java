package com.example.springbookmarks.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import javax.persistence.*;
import java.util.List;


@Data
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity @Table(name = "BOOKMARKS")
public class Bookmark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "URL")
    private String url;

    @OneToMany(mappedBy="bookmark")
    @JsonIgnoreProperties("bookmark")
    public List<Tag> tags;

    public Bookmark(String title, String description, String url) {
        this.title = title;
        this.description = description;
        this.url = url;
    }

}