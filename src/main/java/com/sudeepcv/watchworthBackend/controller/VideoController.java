package com.sudeepcv.watchworthBackend.controller;

import com.sudeepcv.watchworthBackend.modal.Video;
import com.sudeepcv.watchworthBackend.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class VideoController {
    @Autowired
    private VideoRepository videoRepository;


    @GetMapping("/")
    public ResponseEntity<?> test(){
        return ResponseEntity.ok("WatchWorthBackend up and running");
    }

    @PostMapping("/api/videos")
    public ResponseEntity<Video> saveVideo(@RequestBody Video video) {
        Video savedVideo = videoRepository.save(video);
        return ResponseEntity.ok(savedVideo);
    }

    @GetMapping("/api/videos")
    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }
}
