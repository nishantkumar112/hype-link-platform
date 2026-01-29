package com.hypelink.hype_link_platfrom.service;

import com.hypelink.hype_link_platfrom.repository.BlacklistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlacklistService {
    private final BlacklistRepository blacklistRepository;

    public boolean isBlacklisted(String url){
        List<?> matches = blacklistRepository.findByUrlPatternContaining(url);
        return !matches.isEmpty();
    }
}
