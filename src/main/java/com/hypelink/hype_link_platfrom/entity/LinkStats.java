package com.hypelink.hype_link_platfrom.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Entity
@Table(name="link_stats")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LinkStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length=10)
    private String shortCode;

    @Column(nullable = false)
    private Long totalClicks;

    private LocalDateTime lastClickAt;

}
