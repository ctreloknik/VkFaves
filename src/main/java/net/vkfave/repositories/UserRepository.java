package net.vkfave.repositories;

import net.vkfave.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByVkId(Long id);
}