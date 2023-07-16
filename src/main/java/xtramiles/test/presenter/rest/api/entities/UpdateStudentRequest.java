package xtramiles.test.presenter.rest.api.entities;

import javax.validation.constraints.Size;

import lombok.Value;
import xtramiles.test.core.usecases.student.UpdateStudentUseCase;

@Value
public class UpdateStudentRequest {

    @Size(min = 6, max = 6)
    private final String id;

    private final String firstName;

    private final String lastName;

    private final String dateOfBirth;

    public static UpdateStudentUseCase.InputValues to(UpdateStudentRequest updateStudentRequest) {
        return new UpdateStudentUseCase.InputValues(
            updateStudentRequest.getId(),
            updateStudentRequest.getFirstName(),
            updateStudentRequest.getLastName(),
            updateStudentRequest.getDateOfBirth()
        );
    }
}
