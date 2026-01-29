package com.hypelink.hype_link_platfrom.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class LinkResponse {
    private Long id;
    private String shortCode;
    private String originalUrl;
    private Boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime expiryAt;
}
