package xtramiles.test.presenter.rest.api.student;

import java.util.concurrent.CompletableFuture;

import jakarta.servlet.http.HttpServletRequest;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import xtramiles.test.presenter.rest.api.entities.ApiResponse;
import xtramiles.test.presenter.rest.api.entities.CreateStudentRequest;
import xtramiles.test.presenter.rest.api.entities.StudentResponse;
import xtramiles.test.presenter.rest.api.entities.StudentsResponse;
import xtramiles.test.presenter.rest.api.entities.UpdateStudentRequest;
import xtramiles.test.presenter.usecases.security.CreateStudentUseCaseOutputMapper;
import xtramiles.test.presenter.usecases.security.UpdateStudentUseCaseOutputMapper;
import xtramiles.test.core.usecases.UseCaseExecutor;
import xtramiles.test.core.usecases.student.CreateStudentUseCase;
import xtramiles.test.core.usecases.student.UpdateStudentUseCase;
import xtramiles.test.data.db.jpa.entities.StudentData;
import xtramiles.test.data.db.jpa.repositories.StudentRepositoryImpl;

@Component
public class StudentController implements StudentResource{
    private UseCaseExecutor useCaseExecutor;
    private CreateStudentUseCase createStudentUseCase;
    private UpdateStudentUseCase updateStudentUseCase;

    @Autowired
    private StudentRepositoryImpl studentRepository;
    
    public StudentController(
        UseCaseExecutor useCaseExecutor, 
        CreateStudentUseCase createStudentUseCase,
        UpdateStudentUseCase updateStudentUseCase
    ){
        this.useCaseExecutor = useCaseExecutor;
        this.createStudentUseCase = createStudentUseCase;
        this.updateStudentUseCase = updateStudentUseCase;
    }

    @Override
    public CompletableFuture<ResponseEntity<ApiResponse>> createStudent(@Valid @RequestBody CreateStudentRequest createStudentRequest, HttpServletRequest httpServletRequest){
        return useCaseExecutor.execute(
            createStudentUseCase,
            CreateStudentRequest.to(createStudentRequest),
            (outputValues) -> CreateStudentUseCaseOutputMapper.map(outputValues.getStudent(), httpServletRequest)
        );
    }

    @Override
    public CompletableFuture<ResponseEntity<ApiResponse>> updateStudent(@Valid @RequestBody UpdateStudentRequest updateStudentRequest, HttpServletRequest httpServletRequest) {
        return useCaseExecutor.execute(
            updateStudentUseCase,
            UpdateStudentRequest.to(updateStudentRequest),
            (outputValues) -> UpdateStudentUseCaseOutputMapper.map(outputValues.getStudent(), httpServletRequest)
        );
    }

    @Override
    public CompletableFuture<ResponseEntity<ApiResponse>> deleteStudent(String id){
        try {
            studentRepository.deleteById(id);
            return CompletableFuture.completedFuture(
                ResponseEntity.ok(
                    new ApiResponse(true, "Student deleted successfully")
                )
            );
        } catch (Exception e) {
            return new CompletableFuture<ResponseEntity<ApiResponse>>();
        }
    }

    @Override
    public CompletableFuture<ResponseEntity<StudentResponse>> getStudent(String id) {
        try {
            StudentData student = studentRepository.findById(id);
            if(student == null)
                return CompletableFuture.completedFuture(
                    ResponseEntity.ok(
                        StudentResponse.from(student)
                    )
                );    
            return CompletableFuture.completedFuture(
                ResponseEntity.ok(
                    StudentResponse.from(student)
                )
            );
        } catch (Exception e) {
            return new CompletableFuture<ResponseEntity<StudentResponse>>();
        }
    }

    @Override
    public CompletableFuture<ResponseEntity<StudentsResponse>> getAllStudents(HttpServletRequest httpServletRequest) {
        try {
            List<StudentData> students = new ArrayList<StudentData>();

            studentRepository.findAll().forEach(students::add);
            

            if(students.isEmpty())
                return CompletableFuture.completedFuture(
                    ResponseEntity.ok(
                        StudentsResponse.from(students)
                    )
                );    
            return CompletableFuture.completedFuture(
                ResponseEntity.ok(
                    StudentsResponse.from(students)
                )
            );
        } catch (Exception e) {
            return new CompletableFuture<ResponseEntity<StudentsResponse>>();
        }
    }
}
