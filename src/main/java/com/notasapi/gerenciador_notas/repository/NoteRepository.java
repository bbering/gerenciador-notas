package com.notasapi.gerenciador_notas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notasapi.gerenciador_notas.model.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {

}
