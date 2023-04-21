package ru.tolmachev.buyandsell.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tolmachev.buyandsell.models.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {

}
