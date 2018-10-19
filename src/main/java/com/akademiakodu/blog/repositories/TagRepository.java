package com.akademiakodu.blog.repositories;

import com.akademiakodu.blog.models.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

    //todo wyszukiwanie po tagach
}
