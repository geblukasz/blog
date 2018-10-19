package com.akademiakodu.blog.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String tagName;

    @Embedded
    private AuditEntity audit = new AuditEntity();

    @ManyToMany(mappedBy = "tags")
    private Set<Post> posts;




}
