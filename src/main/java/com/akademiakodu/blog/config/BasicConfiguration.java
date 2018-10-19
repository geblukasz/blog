package com.akademiakodu.blog.config;

import com.akademiakodu.blog.models.dto.PostDTO;
import com.akademiakodu.blog.models.dto.TagDTO;
import com.akademiakodu.blog.models.entities.Post;
import com.akademiakodu.blog.models.entities.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.ModelMap;

@Configuration
public class BasicConfiguration {

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        //mapujemy co do czego
        modelMapper.createTypeMap(Post.class, PostDTO.class)
                .addMapping(post -> post.getUser().getId(), PostDTO::setIdOfUser)
                .addMapping(p -> p.getAudit().getAdded(), PostDTO::setCreated);

        modelMapper.createTypeMap(Tag.class, TagDTO.class)
                .addMapping(tag -> tag.getAudit().getAdded(), TagDTO::setCreated);

        return modelMapper;
    }
}
