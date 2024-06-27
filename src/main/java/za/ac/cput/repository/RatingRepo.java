package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Rating;

public interface RatingRepo extends JpaRepository<Rating, Long> {
}
