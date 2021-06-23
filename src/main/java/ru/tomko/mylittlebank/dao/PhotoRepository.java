package ru.tomko.mylittlebank.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tomko.mylittlebank.entity.Photo;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Integer> {
}
