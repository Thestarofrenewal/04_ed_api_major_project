package in.aman.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.aman.entities.PlanSelEntity;

public interface PlanSelRepo extends JpaRepository<PlanSelEntity, Integer> {

	@Query("from PlanSelEntity where caseNum=:caseNum")
	public PlanSelEntity findByCaseNum(Long caseNum);
}
