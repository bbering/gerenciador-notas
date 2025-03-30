package com.notasapi.gerenciador_notas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notes")
public class NotesController {

    @GetMapping("")
    public String getNotes() {
        return "A API está funcionando corretamente!";
    }

}
