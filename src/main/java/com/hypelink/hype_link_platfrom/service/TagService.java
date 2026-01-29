package com.hypelink.hype_link_platfrom.service;

import com.hypelink.hype_link_platfrom.entity.Tag;
import com.hypelink.hype_link_platfrom.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepository tagRepository;

    public Tag createTag(Tag tag){
        return tagRepository.save(tag);
    }

    public List<Tag> getTagsByUser(Long userId){
        return tagRepository.findByCreatedBy(userId);
    }
}
