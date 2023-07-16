package xtramiles.test.presenter.rest.api.entities;

import lombok.Value;
import xtramiles.test.data.db.jpa.entities.StudentData;

@Value
public class StudentResponse {
    private final String id;
    private final String firstName;
    private final String lastName;
    private final String dateOfBirth;

    public static StudentResponse from(StudentData student){
        return new StudentResponse(
            student.getId(),
            student.getFirstName(),
            student.getLastName(),
            student.getDateOfBirth()
        );
    }
}
