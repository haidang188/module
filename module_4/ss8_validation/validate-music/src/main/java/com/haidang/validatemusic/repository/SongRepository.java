package com.haidang.validatemusic.repository;

import com.haidang.validatemusic.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
}
