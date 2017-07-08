package org.gsr.javabrains.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.gsr.javabrains.messenger.model.Profile;
import org.gsr.javabrains.messenger.database.DatabaseClass;

public class ProfileService {
	private Map<String, Profile> profiles = DatabaseClass.getProfiles();

	public ProfileService(){
		profiles.put("santosh", new Profile(1L,"santosh","Raviteja","Gadadasu"));
	}
	
	
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values()); 
	}
	
	public org.gsr.javabrains.messenger.model.Profile getProfile(String profilename){
		return profiles.get(profilename);
	}
	
	public Profile addProfile(Profile profile){
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
		
	}
	
	public Profile updateProfile(Profile profile){
		
		if(profile.getProfileName().isEmpty())
		{
			return null;
		}
		else {
			
			profiles.put(profile.getProfileName(), profile);
			return profile;
		}
		
		
	}
	
	public Profile removeProfile(String profileName){
		return profiles.remove(profileName);
	}
	
	
	
	
}
