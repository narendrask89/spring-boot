package com.nandulabs.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nandulabs.model.entity.VerificationToken;

@Repository
public interface VerificationDao extends CrudRepository<VerificationToken, Long> {
	VerificationToken findByToken(String token);
}
