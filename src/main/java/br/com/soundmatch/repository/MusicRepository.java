package br.com.soundmatch.repository;

import br.com.soundmatch.models.Artist;
import br.com.soundmatch.models.Music;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MusicRepository extends JpaRepository<Music, Long> {
    List<Music> findAll();
    List<Music> findByArtist(Artist artist);
}
