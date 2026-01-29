package com.hypelink.hype_link_platfrom.mapper;

import com.hypelink.hype_link_platfrom.dto.request.CreateLinkRequest;
import com.hypelink.hype_link_platfrom.dto.response.CreateLinkReponse;
import com.hypelink.hype_link_platfrom.dto.response.LinkResponse;
import com.hypelink.hype_link_platfrom.entity.Link;

import java.time.LocalDateTime;

public class LinkMapper {

    public static Link toEntity(CreateLinkRequest request, String shortCode) {
        return Link.builder()
                .shortCode(shortCode)
                .originalUrl(request.getOriginalUrl())
                .createdBy(request.getCreatedBy())
                .active(true)
                .createdAt(LocalDateTime.now())
                .expiryAt(
                        request.getExpiryAt() != null
                                ? request.getExpiryAt()
                                : LocalDateTime.now().plusYears(1)
                )
                .build();
    }

    public static LinkResponse toResponse(Link link){
        return LinkResponse.builder()
                .id(link.getId())
                .shortCode(link.getShortCode())
                .originalUrl(link.getOriginalUrl())
                .active(link.getActive())
                .createdAt(link.getCreatedAt())
                .expiryAt(link.getExpiryAt())
                .build();
    }

    public static CreateLinkReponse toCreateResponse(Link link,String baseUrl){
        return CreateLinkReponse.builder()
                .shortCode(link.getShortCode())
                .shortUrl(baseUrl + "/" + link.getShortCode())
                .originalUrl(link.getOriginalUrl())
                .active(link.getActive())
                .build();
    }
}
