package com.akademiakodu.blog.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class PostComment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String comment;

    @Embedded
    private AuditEntity audit = new AuditEntity();

    @ManyToOne
    @JoinColumn(name = "postId")
    private Post post;





}
