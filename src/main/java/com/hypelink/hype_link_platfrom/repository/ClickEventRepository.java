package com.hypelink.hype_link_platfrom.repository;

import com.hypelink.hype_link_platfrom.entity.ClickEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ClickEventRepository extends JpaRepository<ClickEvent, Long> {

    // Find all clicks for a specific link
    List<ClickEvent> findByShortCode(String shortCode);

    // Find clicks in a date range
    List<ClickEvent> findByShortCodeAndClickEventBetween(
            String shortCode,
            LocalDateTime start,
            LocalDateTime end
    );
}
