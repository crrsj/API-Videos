package br.com.videos.controller;


import br.com.videos.DTO.VideosDTO;
import br.com.videos.service.VideosService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("videos")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class VideosController {

    private final VideosService service;

    @PostMapping
    @Operation(summary = "Endpoint responsável por cadastrar um video.")
    @ApiResponse(responseCode = "201",description = " sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<VideosDTO>createVideos(@RequestBody @Valid VideosDTO videosDTO){
        var create  = service.createVideos(videosDTO);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{id}").buildAndExpand(create.getId()).toUri();
        return ResponseEntity.created(uri).body(new VideosDTO(create));

    }

    @GetMapping
    @Operation(summary = "Endpoint responsável por buscar todos os videos.")
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<List<VideosDTO>>getAllVideos(){
        var getVideos = service.getAllVideos();
        return ResponseEntity.ok().body(getVideos);
    }
}
