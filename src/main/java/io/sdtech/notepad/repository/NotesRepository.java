package io.sdtech.notepad.repository;

import io.sdtech.notepad.model.Notes;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesRepository extends PagingAndSortingRepository<Notes, Long> {
}
