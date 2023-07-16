package xtramiles.test.presenter.rest.api.student;

import xtramiles.test.presenter.rest.api.entities.ApiResponse;
import xtramiles.test.presenter.rest.api.entities.CreateStudentRequest;
import xtramiles.test.presenter.rest.api.entities.StudentResponse;
import xtramiles.test.presenter.rest.api.entities.StudentsResponse;
import xtramiles.test.presenter.rest.api.entities.UpdateStudentRequest;

import java.util.concurrent.CompletableFuture;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import javax.validation.Valid;


@RestController
@RequestMapping("/student")
public interface StudentResource {
    @PostMapping
    CompletableFuture<ResponseEntity<ApiResponse>> createStudent(
        @Valid @RequestBody CreateStudentRequest createStudentRequest, HttpServletRequest httpServletRequest);

    @PatchMapping("/{id}")
    CompletableFuture<ResponseEntity<ApiResponse>> updateStudent(
        @Valid @RequestBody UpdateStudentRequest updateStudentRequest, HttpServletRequest httpServletRequest);

    @DeleteMapping("/{id}")
    CompletableFuture<ResponseEntity<ApiResponse>> deleteStudent(@PathVariable String id);

    @GetMapping("/{id}")
    CompletableFuture<ResponseEntity<StudentResponse>> getStudent(@PathVariable String id);
    
    @GetMapping
    CompletableFuture<ResponseEntity<StudentsResponse>> getAllStudents(
        HttpServletRequest httpServletRequest
    );
}