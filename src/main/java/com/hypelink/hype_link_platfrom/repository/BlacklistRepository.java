package com.hypelink.hype_link_platfrom.repository;

import com.hypelink.hype_link_platfrom.entity.Blacklist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlacklistRepository extends JpaRepository<Blacklist, Long> {

    List<Blacklist> findByUrlPatternContaining(String url);
}
