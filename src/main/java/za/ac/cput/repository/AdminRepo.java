package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Admin;

/**
 * Repository interface for Admin entity.
 * Extends JpaRepository to provide CRUD operations for Admin entities.
 */
@Repository
public interface AdminRepo extends JpaRepository<Admin, String> {

    /**
     * Custom query method to find an Admin by their username.
     *
     * @param username the username of the Admin
     * @return the Admin object if found; otherwise, returns null
     */
    public Admin findAdminByUsername(String username);
}
