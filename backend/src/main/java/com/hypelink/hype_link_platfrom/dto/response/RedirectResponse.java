package com.hypelink.hype_link_platfrom.dto.response;

import lombok.Data;

@Data
public class RedirectResponse {
    private String shortCode;
    private String originalUrl;
}
