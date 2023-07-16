package xtramiles.test.core.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@NoArgsConstructor
@Setter
@ToString
public class Student {
    private String id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;

    public static Student newInstance(String id, String firstName, String lastName, String dateOfBirth) {
        return new Student(id, firstName, lastName, dateOfBirth);
    }
}
