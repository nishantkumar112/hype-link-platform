package com.hypelink.hype_link_platfrom.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "click_events",
        indexes = {
        @Index(name = "idx_shortCode_ts",columnList = "shortCode,clickEvent")
        })
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ClickEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 10)
    private String shortCode;

    @Column(nullable = false)
    private LocalDateTime clickEvent;

    private String ip;

    private String userAgent;

    private String referrer;
}
