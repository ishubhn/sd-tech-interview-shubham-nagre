package io.sdtech.notepad.services.impl;

import io.sdtech.notepad.model.Notes;
import io.sdtech.notepad.model.dto.MessageResponse;
import io.sdtech.notepad.model.dto.NoteRequest;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface NotesService {
    Page<Notes> getAllNotes(int page, int size);

    Optional<Notes> getNoteById(Long id);

    MessageResponse deleteNoteById(Long id);

    Notes saveNewNote(NoteRequest request);

    MessageResponse updateNoteById(Long id, NoteRequest request);
}
