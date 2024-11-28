package br.com.videos.repository;

import br.com.videos.Videos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideosRepository extends JpaRepository<Videos,Long> {
}
