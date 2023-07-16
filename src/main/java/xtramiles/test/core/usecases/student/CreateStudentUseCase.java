package xtramiles.test.core.usecases.student;

import org.springframework.stereotype.Service;

import lombok.Value;
import xtramiles.test.core.domain.Student;
import xtramiles.test.core.usecases.UseCase;

@Service
public class CreateStudentUseCase extends UseCase<CreateStudentUseCase.InputValues, CreateStudentUseCase.OutputValues> {
    private StudentRepository repository;

    public CreateStudentUseCase(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public OutputValues execute(InputValues input) {
        if(repository.existsById(input.getId())){
            throw new RuntimeException("Student already exists");
        }

        Student student = Student.newInstance(
            input.getId(),
            input.getFirstName(),
            input.getLastName(),
            input.getDateOfBirth()
        );
        return new OutputValues(repository.persist(student));
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
