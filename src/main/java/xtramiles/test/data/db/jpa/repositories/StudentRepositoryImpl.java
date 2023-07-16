package xtramiles.test.data.db.jpa.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import xtramiles.test.core.domain.Student;
import xtramiles.test.core.usecases.student.StudentRepository;
import xtramiles.test.data.db.jpa.entities.StudentData;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    
    @Autowired(required = true)
    private JpaStudentRepository repository;

    @Override
    public Student persist(Student student) {
        final StudentData studentData = StudentData.from(student);
        return repository.save(studentData).fromThis();
    }

    @Override
    public boolean existsById(String id) {
        return repository.existsById(id);
    }

    @Override
    public StudentData findById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public StudentData findByFirstName(String firstName) {
        return repository.findByFirstName(firstName).orElse(null);
    }

    @Override
    public List<StudentData> findAll() {
        return repository.findAll();
    }
    
    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
