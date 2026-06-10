package com.haidang.validatemusic.service;

import com.haidang.validatemusic.model.Song;

import java.util.List;
import java.util.Optional;

public interface ISongService {
    void save(Song song);
    List<Song> findAll();
    Optional<Song> findById(Long id);


}
