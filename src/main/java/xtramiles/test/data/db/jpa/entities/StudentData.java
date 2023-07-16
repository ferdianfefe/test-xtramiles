package xtramiles.test.data.db.jpa.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import xtramiles.test.core.domain.Student;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@AllArgsConstructor
@Entity(name = "student")
@Getter
@NoArgsConstructor
@Setter
@Table(name = "student", schema = "public")
@ToString(of = {"id", "firstName", "lastName", "dateOfBirth"})
public class StudentData {
    @Id
    @Column(nullable = false, updatable = true)
    private String id;

    @Column(nullable = false, updatable = true)
    private String firstName;

    @Column(nullable = true, updatable = true)
    private String lastName;

    @Column(nullable = false, updatable = true)
    private String dateOfBirth;

    public static StudentData from(Student student){
        return new StudentData(student.getId(), student.getFirstName(), student.getLastName(), student.getDateOfBirth());
    }

    public Student fromThis(){
        return new Student(
            this.getId(),
            this.getFirstName(),
            this.getLastName(),
            this.getDateOfBirth()
        );
    }
}
