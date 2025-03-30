package com.notasapi.gerenciador_notas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notasapi.gerenciador_notas.model.Note;
import com.notasapi.gerenciador_notas.repository.NoteRepository;

import jakarta.transaction.Transactional;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public List<Note> listNotes() {
        List<Note> notes = noteRepository.findAll();
        return notes;
    }

    @Transactional
    public Note createNote(Note note) {
        noteRepository.save(note);
        return note;
    }

    public void deleteUser(Long id) {
        Optional<Note> noteToDelete = noteRepository.findById(id);
        if (!noteToDelete.isPresent()) {
            throw new RuntimeException("User not found with id: " + id);
        } else {
            noteRepository.deleteById(id);
        }
    }

    @Transactional
    public Note updateNote(Note note, Long id) {
        Note noteToUpdate = noteRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found!"));
        noteToUpdate.setDescription(note.getDescription());
        noteToUpdate.setIsCompleted(note.getIsCompleted());
        noteRepository.save(noteToUpdate);
        return noteToUpdate;
    }

    public Note getNoteById(Long id) {
        Note foundNote = noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nenhum usuario encontrado!"));
        return foundNote;
    }
}
