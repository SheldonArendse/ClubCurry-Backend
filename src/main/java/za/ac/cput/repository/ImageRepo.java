package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Image;


@Repository
public interface ImageRepo extends JpaRepository<Image, Long> {
}
