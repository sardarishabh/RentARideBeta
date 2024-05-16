package com.rentaride.registration.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rentaride.registration.model.Register;

@Repository
public interface RegistrationRepo extends JpaRepository<Register, Integer> {
	
	@Query(value="Select * From member  where full_name=?1", nativeQuery = true)
	Register findByName(String Name);

}
