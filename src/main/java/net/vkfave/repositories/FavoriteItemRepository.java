package net.vkfave.repositories;

import net.vkfave.model.FavoriteItem;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteItemRepository extends JpaRepository<FavoriteItem, Long> {

}