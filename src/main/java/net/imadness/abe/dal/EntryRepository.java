package net.imadness.abe.dal;

import net.imadness.abe.models.Entry;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * DAO-репозиторий, содержащий базовые CRUD-операции для записей {@code Entry}.
 * @see PagingAndSortingRepository
 */
public interface EntryRepository extends PagingAndSortingRepository<Entry, Long> {
    //Page<Entry> findByBoard(Board board, Pageable pageable);
}