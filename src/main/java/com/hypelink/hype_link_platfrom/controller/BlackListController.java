package com.hypelink.hype_link_platfrom.controller;

import com.hypelink.hype_link_platfrom.service.BlacklistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/blacklist")
@RequiredArgsConstructor
public class BlackListController {

    private final BlacklistService blacklistService;

    // Check if URL is blacklisted
    @GetMapping("/check")
    public ResponseEntity<Boolean> isBlacklisted(@RequestParam String url) {
        boolean blocked = blacklistService.isBlacklisted(url);
        return ResponseEntity.ok(blocked);
    }
}
