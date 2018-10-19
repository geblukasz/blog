package com.akademiakodu.blog.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

/*
* DTO - Data Transfer Object  - oddzielenie modelu bazodanowego od modelu webowego
* */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {

    private Long id;
    private String title;
    private String content;
    private Long idOfUser;
    private Date created;
    private Set<TagDTO> tags;


}


