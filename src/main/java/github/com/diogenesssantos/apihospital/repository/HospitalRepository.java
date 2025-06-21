package github.com.diogenesssantos.apihospital.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import github.com.diogenesssantos.apihospital.model.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {
	
	Optional<Hospital> findBynome(String nome);
	
}
