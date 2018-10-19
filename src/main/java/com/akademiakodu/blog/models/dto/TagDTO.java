package com.akademiakodu.blog.models.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

//duzo postow moze miec duzo tagow - manytomany
@Getter
@Setter
public class TagDTO {

    private Long id;
    private String TagName;
    private Date created;
    private Set<PostDTO> posts;

}
