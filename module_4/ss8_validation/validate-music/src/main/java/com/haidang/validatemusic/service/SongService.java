package com.haidang.validatemusic.service;

import com.haidang.validatemusic.model.Song;
import com.haidang.validatemusic.repository.SongRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService  implements ISongService{
    private final SongRepository songRepository;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public Optional<Song> findById(Long id) {
        return songRepository.findById(id);
    }
}
