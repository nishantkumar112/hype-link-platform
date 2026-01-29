package com.hypelink.hype_link_platfrom.dto.analytics;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LinkStatsResponse {

    private String shortCode;
    private Long totalClicks;
}
