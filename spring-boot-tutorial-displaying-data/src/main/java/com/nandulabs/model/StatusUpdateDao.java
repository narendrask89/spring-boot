package com.nandulabs.model;

import org.springframework.data.repository.CrudRepository;

public interface StatusUpdateDao extends CrudRepository<StatusUpdate, Long> {
	StatusUpdate findFirstByOrderByAddedDesc();
}
