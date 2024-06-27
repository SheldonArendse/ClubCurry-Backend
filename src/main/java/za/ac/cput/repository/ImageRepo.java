package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Image;


public interface ImageRepo extends JpaRepository<Image, Long> {
}
