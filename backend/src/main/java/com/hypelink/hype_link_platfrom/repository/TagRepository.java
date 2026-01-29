package com.hypelink.hype_link_platfrom.repository;

import com.hypelink.hype_link_platfrom.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

    List<Tag> findByCreatedBy(Long userId);
}
