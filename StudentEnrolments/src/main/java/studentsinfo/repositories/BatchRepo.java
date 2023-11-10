package studentsinfo.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import studentsinfo.entities.Batch;
import studentsinfo.entities.Student;

public interface BatchRepo extends JpaRepository<Batch, Integer> {

	@Query("from Batch b where :today between b.startDate and b.endDate")
	List<Batch> getRunningBatch(@Param("today") LocalDate today);

	@Query("from Batch b where b.endDate <:today ")
	List<Batch> getCompletedBatch(@Param("today") LocalDate today);

	@Query("select b.student from Batch b where :today between b.startDate and b.endDate")
	List<Student> getRunningBatchStudent(@Param("today") LocalDate today);

	List<Batch> findByCode(String code);

	@Query("from Batch b where  b.startDate between :firstdate and :seconddate ")
	List<Batch> getRunningBatchBetween(@Param("firstdate")LocalDate firstdate,@Param("seconddate") LocalDate seconddate);

	


}
