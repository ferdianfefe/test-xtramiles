package xtramiles.test.presenter.usecases.security;

import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import jakarta.servlet.http.HttpServletRequest;
import xtramiles.test.core.domain.Student;

import xtramiles.test.presenter.rest.api.entities.ApiResponse;

public class UpdateStudentUseCaseOutputMapper {
    public static ResponseEntity<ApiResponse> map(Student student, HttpServletRequest httpServletRequest){
        URI location = ServletUriComponentsBuilder
            .fromContextPath(httpServletRequest)
            .path("/student/{id}")
            .buildAndExpand(student.getId())
            .toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "Student updated successfully"));

    }
}
