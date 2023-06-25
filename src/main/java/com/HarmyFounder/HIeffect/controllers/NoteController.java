package com.HarmyFounder.HIeffect.controllers;

import com.HarmyFounder.HIeffect.models.Note;
import com.HarmyFounder.HIeffect.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/all")
    public List<Note> getAllNotes() {
        return noteService.getAll();
    }

    @GetMapping("/{id}")
    public Note getCertain(@PathVariable("id") Note note) {
        return note;
    }

    @PostMapping("/new")
    public Note createNote(@RequestBody Note note) {
        return noteService.create(note);
    }

    @PostMapping("/findByTag")
    public List<Note> findNotesByTag(@RequestParam String filter) {
        return noteService.findByTag(filter);
    }

    @PutMapping("/{id}/edit")
    public Note updateNote(@PathVariable("id") Note noteToBeUpdated, @RequestBody Note updatedNote) {
        return noteService.update(noteToBeUpdated, updatedNote);
    }

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable("id") Note note) {
        noteService.delete(note);
    }
}
