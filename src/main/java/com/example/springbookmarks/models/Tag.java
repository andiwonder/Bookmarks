package com.example.springbookmarks.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="bookmark_id")
    @JsonIgnoreProperties("tags")
    public Bookmark bookmark;
}

