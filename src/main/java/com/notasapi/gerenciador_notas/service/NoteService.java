package com.notasapi.gerenciador_notas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notasapi.gerenciador_notas.model.Note;
import com.notasapi.gerenciador_notas.repository.NoteRepository;

import jakarta.transaction.Transactional;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Transactional
    public void createNote(Note note) {
        noteRepository.save(note);
    }

}
