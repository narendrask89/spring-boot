package com.nandulabs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nandulabs.model.entity.Profile;
import com.nandulabs.model.entity.SiteUser;
import com.nandulabs.model.repository.ProfileDao;

@Service
public class ProfileService {
	
	@Autowired
	ProfileDao profileDao;
	
	public void save(Profile profile) {
		profileDao.save(profile);
	}
	
	public Profile getUserProfile(SiteUser user) {
		return profileDao.findByUser(user);
	}
}
