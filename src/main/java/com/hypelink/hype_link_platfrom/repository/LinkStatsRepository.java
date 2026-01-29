package com.hypelink.hype_link_platfrom.repository;

import com.hypelink.hype_link_platfrom.entity.LinkStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LinkStatsRepository extends JpaRepository<LinkStats, Long> {

    Optional<LinkStats> findByShortCode(String shortCode);
}
