package com.notasapi.gerenciador_notas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notasapi.gerenciador_notas.model.Note;
import com.notasapi.gerenciador_notas.service.NoteService;

@RestController
@RequestMapping("/api/notes")
public class NotesController {

    @Autowired
    private NoteService noteService;

    @PostMapping("/create")
    public ResponseEntity<?> createTask(@RequestBody Note note) {
        try {
            Note createdNote = noteService.createNote(note);
            return new ResponseEntity<>(createdNote, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<?> listNotes() {
        List<Note> notes = noteService.listNotes();
        return new ResponseEntity<>(notes, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable Long id) {
        noteService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateNote(@PathVariable Long id, @RequestBody Note note) {
        Note noteToUpdate = noteService.updateNote(note, id);
        return new ResponseEntity<>(noteToUpdate, HttpStatus.OK);
    }
}
