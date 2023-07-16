package xtramiles.test.data.db.jpa.repositories;

import xtramiles.test.data.db.jpa.entities.StudentData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface JpaStudentRepository extends JpaRepository<StudentData, String> {
    Optional<StudentData> findById(String id);
    Optional<StudentData> findByFirstName(String firstName);
}
