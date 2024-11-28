package br.com.videos;


import br.com.videos.DTO.VideosDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_videos")
@Data
@NoArgsConstructor
public class Videos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(max = 500)
    private String url;
    private String title;
    @Size(max = 500)
    private String description;


    public Videos(VideosDTO videosDTO) {
        this.url = videosDTO.url();
        this.title = videosDTO.title();
        this.description = videosDTO.description();

    }
}
