package com.nandulabs.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashSet;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.nandulabs.model.Interest;
import com.nandulabs.model.Profile;
import com.nandulabs.model.SiteUser;
import com.nandulabs.service.InterestService;
import com.nandulabs.service.ProfileService;
import com.nandulabs.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
@Transactional
public class ProfileTest {
	
	@Autowired 
	private UserService userService;
	
	@Autowired 
	private ProfileService profileService;
	
	@Autowired
	private InterestService interestService;
	
	private SiteUser[] users = {
		new SiteUser("ljlkj@nandulabs.com", "lkjlkjlk"),
		new SiteUser("dafdf@nandulabs.com", "gfhgfh"),
		new SiteUser("ghdgfhg@nandulabs.com", "wereretr")
	};
	
	private String[][] interests = {
			{"music", "guitar_xxxxxx", "plants"},
			{"music", "music", "philosophy_lkjlkjlk"},
			{"philosophy_lkjlkjlk", "football"}
	};
	
	@Test
	public void testInterests() {
		
		for(int i=0; i<users.length; i++) {
			SiteUser user = users[i];
			String[] interestArray = interests[i];
			
			userService.register(user);
			
			HashSet<Interest> interestSet = new HashSet<>();
			
			for(String interestText: interestArray) {
				Interest interest = interestService.createIfNotExists(interestText);
				interestSet.add(interest);
				
				assertNotNull("Interest should not be null", interest);
				assertNotNull("Interest should have ID", interest.getId());
				assertEquals("Text should match", interestText, interest.getName());
			}
			
			Profile profile = new Profile(user);
			profile.setInterests(interestSet);
			profileService.save(profile);
			
			Profile retrievedProfile = profileService.getUserProfile(user);
			
			assertEquals("Interest sets should match", interestSet, retrievedProfile.getInterests());
		}
	}
}







