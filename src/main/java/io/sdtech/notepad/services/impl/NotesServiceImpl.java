package io.sdtech.notepad.services.impl;

import io.sdtech.notepad.exceptions.NoSuchNoteException;
import io.sdtech.notepad.model.Notes;
import io.sdtech.notepad.model.dto.MessageResponse;
import io.sdtech.notepad.model.dto.NoteRequest;
import io.sdtech.notepad.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NotesServiceImpl implements NotesService {
    @Autowired
    private NotesRepository repo;

    @Override
    public Page<Notes> getAllNotes(int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        return repo.findAll(paging);
    }

    @Override
    public Optional<Notes> getNoteById(Long id) {
        return repo.findById(id);
    }

    @Override
    public MessageResponse deleteNoteById(Long id) {
        if (getNoteById(id).isPresent()) {
            repo.deleteById(id);
        } else {
            throw new NoSuchNoteException("No such note found with id - " + id + " Exception");
        }
        return null;
    }

    @Override
    public Notes saveNewNote(NoteRequest request) {
        Notes note = new Notes(request.getTitle(), request.getContent());
        repo.save(note);
        return note;
    }

    @Override
    public MessageResponse updateNoteById(Long id, NoteRequest request) {
        Optional<Notes> cNote = getNoteById(id);

        if (cNote.isPresent()) {
            cNote.get().setTitle(request.getTitle());
            cNote.get().setContent(request.getContent());

            repo.save(cNote.get());
        }
        return new MessageResponse("Successfully Created");
    }
}
