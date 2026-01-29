package com.hypelink.hype_link_platfrom.controller;

import com.hypelink.hype_link_platfrom.entity.Tag;
import com.hypelink.hype_link_platfrom.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tags")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    // Create a new tag
    @PostMapping
    public ResponseEntity<Tag> createTag(@RequestBody Tag tag) {
        Tag created = tagService.createTag(tag);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // Get all tags for a user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Tag>> getUserTags(@PathVariable Long userId) {
        return ResponseEntity.ok(tagService.getTagsByUser(userId));
    }
}
