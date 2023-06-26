package com.HarmyFounder.HIeffect.services;

import com.HarmyFounder.HIeffect.models.Note;
import com.HarmyFounder.HIeffect.models.User;
import com.HarmyFounder.HIeffect.repositories.NoteRepository;
import com.HarmyFounder.HIeffect.repositories.UserDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoritesService {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private UserDetailRepo userDetailRepo;

    public List<Note> getFavorites(User user) {
        return user.getFavorites();
    }

    public Note changeFavStatus(User user, Note note) {
        List<Note> favorites = user.getFavorites();
        if (favorites.contains(note)) {
            favorites.remove(note);
        } else {
            favorites.add(note);
        }
        userDetailRepo.save(user);
        return note;
    }

}
