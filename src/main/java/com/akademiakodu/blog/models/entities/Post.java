package com.akademiakodu.blog.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String content;

    @Embedded
    private AuditEntity audit = new AuditEntity();

    @OneToMany(mappedBy = "post", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Set<PostComment> comments = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    //albo mamy joinTable + MappedBy albo JoinTable + JoinTable
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "mapPostTag",
            joinColumns = {@JoinColumn(name = "postId")},
            inverseJoinColumns = {@JoinColumn(name = "tagId")})
    private Set<Tag> tags;

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void addComment(PostComment postComment) {
        comments.add(postComment);
        postComment.setPost(this);
    }

    public void removeComment(PostComment postComment) {
        comments.remove(postComment);
        postComment.setComment(null);
    }

}
