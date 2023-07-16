package xtramiles.test.presenter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import xtramiles.test.core.usecases.student.CreateStudentUseCase;
import xtramiles.test.core.usecases.student.StudentRepository;
import xtramiles.test.core.usecases.student.UpdateStudentUseCase;

@Configuration
public class Module {
    @Bean
    public CreateStudentUseCase createStudentUseCase(StudentRepository repository){
        return new CreateStudentUseCase(repository);
    }

    @Bean
    public UpdateStudentUseCase updateStudentUseCase(StudentRepository repository){
        return new UpdateStudentUseCase(repository);
    }
}
