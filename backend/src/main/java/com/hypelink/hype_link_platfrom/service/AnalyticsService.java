package com.hypelink.hype_link_platfrom.service;

import com.hypelink.hype_link_platfrom.repository.LinkStatsRepository;
import com.hypelink.hype_link_platfrom.entity.LinkStats;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnalyticsService {

    private final LinkStatsRepository linkStatsRepository;

    public LinkStats getLinkStat(String shortcode){
        return linkStatsRepository.findByShortCode(shortcode).orElse(null);
    }

    public void recordClick(String shortcode){
        LinkStats stats = linkStatsRepository.findByShortCode(shortcode).orElse(LinkStats.builder().shortCode(shortcode).totalClicks(0L).build());
        stats.setTotalClicks(stats.getTotalClicks()+1);
        linkStatsRepository.save(stats);
    }
}
