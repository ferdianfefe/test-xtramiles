package xtramiles.test.presenter.rest.api.entities;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Value;
import xtramiles.test.core.usecases.student.CreateStudentUseCase;

@Value
public class CreateStudentRequest {
    @NotBlank
    @Size(min = 6, max = 6)
    private final String id;

    @NotBlank
    private final String firstName;

    private final String lastName;

    @NotBlank
    private final String dateOfBirth;

    public static CreateStudentUseCase.InputValues to(CreateStudentRequest createStudentRequest) {
        return new CreateStudentUseCase.InputValues(
            createStudentRequest.getId(),
            createStudentRequest.getFirstName(),
            createStudentRequest.getLastName(),
            createStudentRequest.getDateOfBirth()
        );
    }
}
