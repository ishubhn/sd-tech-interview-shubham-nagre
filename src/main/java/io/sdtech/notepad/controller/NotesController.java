package io.sdtech.notepad.controller;

import io.sdtech.notepad.model.Notes;
import io.sdtech.notepad.model.dto.MessageResponse;
import io.sdtech.notepad.model.dto.NoteRequest;
import io.sdtech.notepad.services.impl.NotesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/notes")
public class NotesController {
    @Autowired
    private NotesServiceImpl service;

    @GetMapping("/all")
    public ResponseEntity<List<Notes>> getAllNotes(@RequestParam int page, @RequestParam int size) {
        Page<Notes> pager = service.getAllNotes(page, size);
        return new ResponseEntity<>(pager.getContent().stream().collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Notes>> getNoteById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getNoteById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteNoteById(Long id) {
        return ResponseEntity.ok(service.deleteNoteById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Notes> createNote(@RequestBody NoteRequest req) {
        return ResponseEntity.ok(service.saveNewNote(req));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageResponse> updateNote(@PathVariable Long id, @RequestBody NoteRequest req) {
        return ResponseEntity.ok(service.updateNoteById(id, req));
    }
}
