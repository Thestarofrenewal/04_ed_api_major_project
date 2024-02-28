package in.aman.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.aman.entities.EducationEntity;

public interface EducationRepo extends JpaRepository<EducationEntity, Integer> {

	@Query("from EducationEntity where caseNum=:caseNum")
	public EducationEntity findByCaseNum(Long caseNum);
}
