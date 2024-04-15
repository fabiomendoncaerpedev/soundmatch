package br.com.soundmatch.repository;

import br.com.soundmatch.models.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicRepository extends JpaRepository<Music, Long> {
}
