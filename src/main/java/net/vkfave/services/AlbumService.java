package net.vkfave.services;

import net.vkfave.dto.AlbumDto;
import net.vkfave.model.Album;
import net.vkfave.model.Tag;
import net.vkfave.repositories.AlbumRepository;
import net.vkfave.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;
    
    @Autowired
    private UserRepository userRepository;

    public Album getTagById(Long id) {
        return albumRepository.findOne(id);
    }

    public Album insertAlbum(AlbumDto albumDto) {
    	Album album = new Album();
    	album.setName(albumDto.getName());
    	album.setUser(userRepository.findOne(albumDto.getUserId()));
        return albumRepository.save(album);
    }

    public Album updateAlbum(AlbumDto albumDto, Long id) {
    	Album album = albumRepository.findOne(id);
    	album.setName(albumDto.getName());
    	return albumRepository.save(album);
    }

    public void deleteAlbum(Long id) {
        userRepository.delete(id);
    }
}
