package br.com.videos.DTO;

import br.com.videos.Videos;
import jakarta.validation.constraints.NotBlank;

public record VideosDTO(
                        @NotBlank (message = "não pode estar em branco !")
                        String url,
                        @NotBlank (message = "não pode estar em branco !")
                        String title,
                        String description) {

    public VideosDTO(Videos videos){
        this(videos.getUrl(), videos.getTitle(), videos.getDescription());
    }


}
