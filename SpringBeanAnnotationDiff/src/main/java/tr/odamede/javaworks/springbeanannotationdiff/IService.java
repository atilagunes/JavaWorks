package tr.odamede.javaworks.springbeanannotationdiff;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/*
You can use a component marked interface as repository
But please dont do that.
if one sets repository scan path, this component won't fit that configuration.
// TODO : This topic needs more studies.
 */
@Service
public interface IService extends JpaRepository<StudentEntity,Integer> {

}
