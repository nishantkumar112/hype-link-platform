package com.hypelink.hype_link_platfrom.repository;

import com.hypelink.hype_link_platfrom.entity.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface LinkRepository extends JpaRepository<Link,Long> {
    Optional<Link> findByShortCode(String shortCode);

    List<Link> findByCreatedBy(Long userId);

    List<Link> findByActiveTrue();

    List<Link> findByExpiryAtBefore(LocalDateTime now);
}
