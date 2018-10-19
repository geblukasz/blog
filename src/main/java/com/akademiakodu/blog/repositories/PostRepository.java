package com.akademiakodu.blog.repositories;

import com.akademiakodu.blog.models.entities.Post;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    
/*
    Iterable<Post> findAllByTitleContains(String title);

    List<Post> findAllByTitleContains(String title, Sort.Direction fromString, String sortField);

    List<Post> findAllByTitleContainsOrContentContains(String searchPhraseLikeTitle, String searchPhraseLikeContent);
*/

    //todo 2 metody wyszukiwania


}
