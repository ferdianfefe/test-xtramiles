package xtramiles.test.presenter.rest.api.entities;

import java.util.List;

import lombok.Value;
import xtramiles.test.data.db.jpa.entities.StudentData;

@Value
public class StudentsResponse {

    private final List<StudentData> students;

    public static StudentsResponse from(List<StudentData> students){
        return new StudentsResponse(students);
    }
}