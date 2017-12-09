package net.vkfave.services;

import net.vkfave.dto.TagDto;
import net.vkfave.model.Tag;
import net.vkfave.repositories.TagRepository;
import net.vkfave.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TagService {

    @Autowired
    private TagRepository tagRepository;
    
    @Autowired
    private UserRepository userRepository;

    public Tag getTagById(Long id) {
        return tagRepository.findOne(id);
    }

    public Tag insertTag(TagDto tagDto) {
        Tag tag = new Tag();
        tag.setName(tagDto.getName());
        tag.setUser(userRepository.findOne(tagDto.getUserId()));
        return tagRepository.save(tag);
    }

    public Tag updateTag(TagDto tagDto, Long id) {
    	Tag dbTag = tagRepository.findOne(id);
    	dbTag.setName(tagDto.getName());
    	return tagRepository.save(dbTag);
    }

    public void deleteTag(Long id) {
    	tagRepository.delete(id);
    }
}
