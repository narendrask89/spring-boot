package com.nandulabs.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nandulabs.model.Interest;
import com.nandulabs.model.InterestDao;

@Service
public class InterestService {
	@Autowired
	private InterestDao interestDao;
	
	public long count() {
		return interestDao.count();
	}
	
	public Interest get(String interestName) {
		return interestDao.findOneByName(interestName);
	}
	
	public void save(Interest interest) {
		interestDao.save(interest);
	}
	
	public Interest createIfNotExists(String interestText) {
		Interest interest = interestDao.findOneByName(interestText);
		
		if(interest == null) {
			interest = new Interest(interestText);
			interestDao.save(interest);
		}
		
		return interest;
	}
}
