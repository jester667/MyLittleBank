package ru.tomko.mylittlebank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.tomko.mylittlebank.dao.PhotoRepository;
import ru.tomko.mylittlebank.entity.Photo;
import ru.tomko.mylittlebank.entity.User;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("photo")
public class PhotoController {
    @Autowired
    private PhotoRepository photoRepository;

    @GetMapping
    public List<Photo> getPhotos() {
        return photoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<String> addPhoto(@RequestBody MultipartFile file, @RequestBody User user) throws IOException {
        photoRepository.save(new Photo(file.getBytes(), user));
        return ResponseEntity.ok("Good photo");
    }

    @PutMapping
    public ResponseEntity<String> updatePhoto(@RequestBody Photo photo) {
        photoRepository.save(photo);
        return ResponseEntity.ok("ok");
    }

    @DeleteMapping("{id}")
    public void deletePhoto(@PathVariable int id) {
        photoRepository.deleteById(id);
    }

}
