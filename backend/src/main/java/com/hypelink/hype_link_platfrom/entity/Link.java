package com.hypelink.hype_link_platfrom.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "links",
        indexes = {
                @Index(name = "idx_shortCode",columnList = "shortCode"),
        @Index(name="idx_created_by", columnList = "createdBy")
        }
)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true,length = 10)
    private String shortCode;

    @Column(nullable = false,length = 2048)
    private String originalUrl;

    @Column(nullable = false)
    private Long createdBy;

    @Column(nullable = false)
    private Boolean active;

    @Column(nullable = false)
    private LocalDateTime expiryAt;

    @Column(nullable = false,updatable = false)
    private LocalDateTime createdAt;

}
