package studentsinfo.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import studentsinfo.entities.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

	@Query("from Student s where s.batch.code=:Code")
	Page<Student> findByCode(@Param("Code") String Code, Pageable pageable);

	List<Student> findByBatchid(Integer batch);

	List<Student> findByNameContaining(String name);

}
