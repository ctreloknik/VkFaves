package net.imadness.abe.dal;

import net.imadness.abe.models.Board;
import org.springframework.data.jpa.repository.JpaRepository;

/**
  * DAO-репозиторий, содержащий базовые CRUD-операции для досок {@link Board}.
 */
public interface BoardRepository extends JpaRepository<Board, Long> {
}