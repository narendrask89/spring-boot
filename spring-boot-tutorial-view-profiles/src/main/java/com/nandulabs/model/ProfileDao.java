package com.nandulabs.model;

import org.springframework.data.repository.CrudRepository;

public interface ProfileDao extends CrudRepository<Profile, Long> {	
	Profile findByUser(SiteUser user);
}
