package net.vkfave.services;

import java.util.ArrayList;
import java.util.List;

import net.vkfave.dto.FavoriteItemDto;
import net.vkfave.dto.ImageDto;
import net.vkfave.dto.TagDto;
import net.vkfave.model.FavoriteItem;
import net.vkfave.model.Image;
import net.vkfave.model.Tag;
import net.vkfave.model.User;
import net.vkfave.repositories.AlbumRepository;
import net.vkfave.repositories.FavoriteItemRepository;
import net.vkfave.repositories.TagRepository;
import net.vkfave.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FavoriteItemService {

    @Autowired
    private FavoriteItemRepository faveItemRepository;
    
    @Autowired
    private TagRepository tagRepository;
    
    @Autowired
    private AlbumRepository albumRepository; 
    
    @Autowired
    private UserRepository userRepository;
    
    // Tags converters
    
    private TagDto getTagDtoFromTag(Tag tag) {
    	TagDto dto = new TagDto();
    	dto.setId(tag.getId());
    	dto.setName(tag.getName());
    	return dto;
    }
    
    private List<TagDto> getTagsDtoFromTags(List<Tag> tags) {
    	List<TagDto> tagsDto = new ArrayList<TagDto>();
    	for (Tag tag : tags) {
    		tagsDto.add(getTagDtoFromTag(tag));
    	}
    	return tagsDto;
    }
    
    // Images converters
    
    private ImageDto getImageDtoFromImage(Image image) {
    	ImageDto dto = new ImageDto();
    	dto.setId(image.getId());
    	dto.setUrl(image.getUrl());
    	return dto;
    }
    
    private List<ImageDto> getImagesDtoFromImages(List<Image> images) {
    	List<ImageDto> imagesDto = new ArrayList<ImageDto>();
    	for (Image image : images) {
    		imagesDto.add(getImageDtoFromImage(image));
    	}
    	return imagesDto;
    }
    
    private Image getImageFromImageDto(ImageDto dto) {
    	Image image = new Image();
    	image.setId(dto.getId());
    	image.setUrl(dto.getUrl());
    	return image;
    }
    
    private List<Image> getImagesFromImageDtos(List<ImageDto> imageDtos) {
    	List<Image> images = new ArrayList<Image>();
    	for (ImageDto imageDto : imageDtos) {
    		images.add(getImageFromImageDto(imageDto));
    	}
    	return images;
    }
    
    // Service methods

    public List<FavoriteItemDto> getFaves(List<FavoriteItemDto> itemDtos, Long userId) {
    	User user = userRepository.findOne(userId);
    	
    	for (FavoriteItemDto itemDto : itemDtos) {
    		FavoriteItem item = faveItemRepository.findByVkId(itemDto.getVkId());
    		// если такого поста еще нет
    		if (item == null) {
    			FavoriteItem newItem = new FavoriteItem();
            	newItem.setVkId(itemDto.getVkId());
            	newItem.setText(itemDto.getText());
            	newItem.setImages(getImagesFromImageDtos(itemDto.getImages()));
            	newItem.setUser(user);
            	newItem = faveItemRepository.save(newItem);
            	itemDto.setId(newItem.getId());
    		} else {
    			// если пост есть, то требуется обновить данные о нем
    			itemDto.setId(item.getId());
    			itemDto.setTags(getTagsDtoFromTags(item.getTags()));
    			itemDto.setImages(getImagesDtoFromImages(item.getImages()));
    		}
    	}
    	return itemDtos;
    }

    public FavoriteItemDto updateFave(FavoriteItemDto faveDto) {
    	FavoriteItem faveItem = faveItemRepository.findOne(faveDto.getId());
    	faveItem.setName(faveDto.getName());
    	faveItemRepository.save(faveItem);
    	return faveDto;
    }
    
    public TagDto createTag(TagDto dto, Long faveItemId) {
    	User user = userRepository.findOne(dto.getUserId());
    	Tag newTag = new Tag(dto.getName(), user);
    	newTag = tagRepository.save(newTag);
    	dto.setId(newTag.getId());
    	
    	FavoriteItem fave = faveItemRepository.getOne(faveItemId);
    	fave.getTags().add(newTag);
    	faveItemRepository.save(fave);
    	return dto;
    }
    
    public void deleteTagFromFave(Long tagId, Long faveItemId) {
    	FavoriteItem fave = faveItemRepository.getOne(faveItemId);
    	List<Tag> tags = fave.getTags();
    	for (Tag tag : tags) {
    		if (tag.getId() == tagId) {
    			tags.remove(tag);
    			break;
    		}
    	}
    	fave.setTags(tags);
    	faveItemRepository.save(fave);
    }

    public void deleteFaveItem(Long id) {
        faveItemRepository.delete(id);
    }
}
