package net.vkfave.services;

import net.vkfave.dto.AlbumDto;
import net.vkfave.model.Album;
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

    public AlbumDto insertAlbum(AlbumDto albumDto) {
    	Album album = new Album();
    	album.setName(albumDto.getName());
    	album.setUser(userRepository.findOne(albumDto.getUserId()));
    	album = albumRepository.save(album);
    	albumDto.setId(album.getId());
        return albumDto;
    }

    public AlbumDto updateAlbum(AlbumDto albumDto) {
    	Album album = albumRepository.findOne(albumDto.getId());
    	album.setName(albumDto.getName());
    	albumRepository.save(album);
    	return albumDto;
    }

    public void deleteAlbum(Long id) {
        userRepository.delete(id);
    }
}
