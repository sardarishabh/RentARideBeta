package com.rentaride.registration.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentaride.registration.exception.RegistrationException;
import com.rentaride.registration.model.Register;
import com.rentaride.registration.repo.RegistrationRepo;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RegistrationService {

	@Autowired
	RegistrationRepo registrationRepo;

	@Transactional
	public Register registerUser(Register user) {
		log.info("adding new Member to record...");
		registrationRepo.save(user);
		log.info("done.");
		return user;
	}

	@Transactional
	public List<Register> getAllRegistrations() {
		log.info("loading all registrations...");
		List<Register> registrationList = registrationRepo.findAll();
		if (registrationList.size() <= 0) {
			log.error("error, no registrations found");
			throw new RegistrationException("DB error! no registrations found");
		} else {
			return registrationList;
		}
	}

	@Transactional
	public Register findRegistrationById(int id) {
		log.info("searching Registration record...");
		return registrationRepo.findById(id)
				.orElseThrow(() -> new RegistrationException("Registration with id " + id + " does not exist"));
	}

	@Transactional
	public Register findRegistrationByName(String name) throws RegistrationException {
		log.info("searching Registration record...");

		Register registrationList = registrationRepo.findByName(name);
		if (registrationList == null) {
			throw new RegistrationException("Registration with name " + name + " does not exist");
		} else {
			return registrationList;
		}
	}

	@Transactional
	public String userRole(int id) {
		log.info("fetching user-role...");
		Optional<Register> registrationList = registrationRepo.findById(id);
		String userRole = null;
		if (!registrationList.isPresent()) {
			throw new RegistrationException("Registration with id " + id + " does not exist");
		} else {
			userRole = registrationList.get().getUserRole();
		}
		return userRole;
	}

}
