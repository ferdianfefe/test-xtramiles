package xtramiles.test.core.usecases.student;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonpatch.JsonPatch;

import lombok.Value;
import xtramiles.test.core.domain.Student;
import xtramiles.test.core.usecases.UseCase;
import xtramiles.test.data.db.jpa.entities.StudentData;

@Service
public class UpdateStudentUseCase extends UseCase<UpdateStudentUseCase.InputValues, UpdateStudentUseCase.OutputValues> {
    private StudentRepository repository;

    public UpdateStudentUseCase(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public OutputValues execute(InputValues input) {
        if(!repository.existsById(input.getId())){
            throw new RuntimeException("Student does not exists");
        }

        StudentData student = this.repository.findById(input.getId());
        
        // update student
        if ( input.getFirstName() != null && !input.getFirstName().isEmpty() )
            student.setFirstName(input.getFirstName());
        if ( input.getLastName() != null && !input.getLastName().isEmpty() )
            student.setLastName(input.getLastName());
        if ( input.getDateOfBirth() != null && !input.getDateOfBirth().isEmpty() )
            student.setDateOfBirth(input.getDateOfBirth());
        return new OutputValues(repository.persist(student.fromThis()));
    }

    @Value
    public static class InputValues implements UseCase.InputValues {
        private final String id;
        private final String firstName;
        private final String lastName;
        private final String dateOfBirth;
    }

    @Value
    public static class OutputValues implements UseCase.OutputValues {
        private final Student student;
    }
}
