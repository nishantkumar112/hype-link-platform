package com.hypelink.hype_link_platfrom.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateLinkReponse {
    private  String shortCode;
    private String shortUrl;
    private String originalUrl;
    private Boolean active;
}
