package tr.odamede.javaworks.springbeanannotationdiff;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<StudentEntity, Integer> {

}
