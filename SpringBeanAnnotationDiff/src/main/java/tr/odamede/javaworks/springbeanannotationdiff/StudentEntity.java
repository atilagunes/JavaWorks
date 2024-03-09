package tr.odamede.javaworks.springbeanannotationdiff;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "studentName", nullable = false)
    private String studentName;
}
