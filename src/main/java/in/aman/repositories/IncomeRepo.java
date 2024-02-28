package in.aman.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.aman.entities.IncomeEntity;

public interface IncomeRepo extends JpaRepository<IncomeEntity, Integer> {

	@Query("from IncomeEntiity where caseNum=:caseNum")
	public IncomeEntity findBycaseNum(Long caseNum);
}
