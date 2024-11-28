package br.com.videos.service;

import br.com.videos.DTO.VideosDTO;
import br.com.videos.Videos;
import br.com.videos.repository.VideosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VideosService {

    private final VideosRepository repository;

    public Videos createVideos(VideosDTO videosDTO){
        var create = new Videos(videosDTO);
        return repository.save(create);
    }

    public List<VideosDTO> getAllVideos(){
        var getVideos = repository.findAll().stream().map(VideosDTO::new).toList();
        return getVideos;

    }
}
