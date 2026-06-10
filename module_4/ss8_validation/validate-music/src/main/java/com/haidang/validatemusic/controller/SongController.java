package com.haidang.validatemusic.controller;

import com.haidang.validatemusic.model.Song;
import com.haidang.validatemusic.service.SongService;
import jakarta.validation.Valid;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/songs")
public class SongController {
    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping("")
    public String showSong(Model model) {
        List<Song> songs = songService.findAll();
        model.addAttribute("songs", songs);
        return "list";
    }

    @GetMapping("/create")
    public String createSong(Model model) {
        model.addAttribute("song", new Song());
        return "create";
    }

    @PostMapping("/save")
    public String saveSong(@Valid @ModelAttribute Song song, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "create";
        }
        songService.save(song);
        return "redirect:/songs";
    }

    @GetMapping("/edit/{id}")
    public String editSong(@PathVariable Long id, Model model) {
        Optional<Song> songOptional = songService.findById(id);
        if (songOptional.isEmpty()) {
            return "redirect:/songs";
        }
        model.addAttribute("song", songOptional.get());
        return "edit";
    }

    @PostMapping("/update")
    public String updateSong(@Valid @ModelAttribute Song song, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        songService.save(song);
        return "redirect:/songs";
    }
}
