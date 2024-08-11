package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Image;
import za.ac.cput.domain.MenuItem;

import java.util.List;


@Repository
public interface ImageRepo extends JpaRepository<Image, Long> {

    public Image findImageByItemId(MenuItem id);
}
