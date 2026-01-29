package com.hypelink.hype_link_platfrom.service;

import com.hypelink.hype_link_platfrom.dto.request.CreateLinkRequest;
import com.hypelink.hype_link_platfrom.dto.response.LinkResponse;
import com.hypelink.hype_link_platfrom.entity.Link;
import com.hypelink.hype_link_platfrom.exception.LinkExpiredException;
import com.hypelink.hype_link_platfrom.exception.LinkNotFoundException;
import com.hypelink.hype_link_platfrom.mapper.LinkMapper;
import com.hypelink.hype_link_platfrom.repository.LinkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LinkService {

    private final LinkRepository linkRepository;

    @Value("${app.base-url}")
    private String baseUrl;

    // -----------------------
    // Create Link (WRITE)
    // -----------------------
    public CreateLinkResponse createLink(CreateLinkRequest request) {

        String shortCode = generateShortCode();

        Link link = LinkMapper.toEntity(request, shortCode);
        Link saved = linkRepository.save(link);

        return LinkMapper.toCreateResponse(saved, baseUrl);
    }

    // -----------------------
    // Resolve Link (HOT PATH)
    // -----------------------
    public String resolveShortLink(String shortCode) {

        Link link = linkRepository.findByShortCode(shortCode)
                .orElseThrow(() ->
                        new LinkNotFoundException("Short link not found")
                );

        if (!link.getActive()) {
            throw new LinkExpiredException("Link is inactive");
        }

        if (link.getExpiryAt().isBefore(LocalDateTime.now())) {
            throw new LinkExpiredException("Link has expired");
        }

        return link.getOriginalUrl();
    }

    // -----------------------
    // Dashboard
    // -----------------------
    public List<LinkResponse> getLinksByUser(Long userId) {
        return linkRepository.findByCreatedBy(userId)
                .stream()
                .map(LinkMapper::toResponse)
                .collect(Collectors.toList());
    }

    // -----------------------
    // Base62 Generator
    // -----------------------
    private String generateShortCode() {
        return Long.toString(System.nanoTime(), 36);
    }
}
