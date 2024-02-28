package in.aman.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.aman.entities.AppEntity;

public interface AppRepo extends JpaRepository<AppEntity, Long> {
	
	public List<AppEntity> fetchUserApps();
	
	@Query(value = "from AppEntity where userId=:userId")
	public List<AppEntity> fetchCwApps(Integer userId);

}
