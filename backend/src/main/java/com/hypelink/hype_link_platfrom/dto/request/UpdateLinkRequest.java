package com.hypelink.hype_link_platfrom.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UpdateLinkRequest {
    private LocalDateTime expiryAt;
    private Boolean active;
}
