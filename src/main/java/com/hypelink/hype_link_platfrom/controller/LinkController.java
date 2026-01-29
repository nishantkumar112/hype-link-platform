package com.hypelink.hype_link_platfrom.controller;

import com.hypelink.hype_link_platfrom.dto.request.CreateLinkRequest;
import com.hypelink.hype_link_platfrom.dto.response.CreateLinkReponse;
import com.hypelink.hype_link_platfrom.dto.response.LinkResponse;
import com.hypelink.hype_link_platfrom.service.LinkService;
import com.hypelink.hype_link_platfrom.entity.Link;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("api/links")
@RequiredArgsConstructor
public class LinkController {

    private final LinkService linkService;

    @PostMapping
    public ResponseEntity<CreateLinkReponse> createLink(@RequestBody CreateLinkRequest linkRequest){
        CreateLinkResponse createLinkReponse = linkService.createLink(linkRequest);
        return new ResponseEntity<>(createLinkReponse,HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<LinkResponse>> getUserLinks(@PathVariable Long userId){
        List<LinkResponse> userLinks = linkService.getLinksByUser(userId);
        return ResponseEntity.ok(userLinks);
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> redirectToOriginal(@PathVariable String shortCode){
        String originalUrl = linkService.getOriginalUrl(shortCode);
        if(originalUrl == null){
            return ResponseEntity.notFound().build();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(originalUrl));
        return new ResponseEntity<>(headers,HttpStatus.FOUND);
    }
}
