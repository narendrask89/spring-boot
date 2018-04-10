package com.nandulabs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nandulabs.model.Profile;
import com.nandulabs.model.ProfileDao;
import com.nandulabs.model.SiteUser;

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
