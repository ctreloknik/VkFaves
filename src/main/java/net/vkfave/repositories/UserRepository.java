package net.vkfave.repositories;

import net.vkfave.dao.UserDao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * DAO-репозиторий, содержащий базовые CRUD-операции для записей {@code UserDao}.
 * @see PagingAndSortingRepository
 */
public interface UserRepository extends JpaRepository<UserDao, Long> {
    UserDao findById(Long id);
}