package com.hypelink.hype_link_platfrom.controller;

import com.hypelink.hype_link_platfrom.entity.LinkStats;
import com.hypelink.hype_link_platfrom.service.AnalyticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/analytics")
@RequiredArgsConstructor
public class AnalyticsController {

    private final AnalyticsService analyticsService;

    // Get click stats for a link
    @GetMapping("/link/{shortcode}")
    public ResponseEntity<LinkStats> getLinkStats(@PathVariable String shortcode) {
        LinkStats stats = analyticsService.getLinkStat(shortcode);
        if (stats == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(stats);
    }
}
