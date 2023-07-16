package xtramiles.test.core.usecases.student;

import java.util.List;

import xtramiles.test.core.domain.Student;
import xtramiles.test.data.db.jpa.entities.StudentData;

public interface StudentRepository {
    Student persist(Student student);

    boolean existsById(String id);

    StudentData findById(String id);

    StudentData findByFirstName(String firstName);

    List<StudentData> findAll();

    void deleteById(String id);
}
