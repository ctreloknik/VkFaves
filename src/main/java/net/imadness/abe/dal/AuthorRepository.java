package net.imadness.abe.dal;

import net.imadness.abe.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * DAO-репозиторий, содержащий базовые CRUD-операции для записей {@link Author}.
 */
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findByNickname(String nickname);
    Author findByIpAddress(String ipAddress);
}