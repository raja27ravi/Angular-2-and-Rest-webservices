package org.gsr.javabrains.messenger.database;

import java.util.HashMap;
import java.util.Map;

import org.gsr.javabrains.messenger.model.Message;
import org.gsr.javabrains.messenger.model.Profile;

public class DatabaseClass {

	///this is the stub for DB
	
	private static Map<Long,Message> messages = new HashMap<>();
	private static Map<String,Profile> profiles = new HashMap<>();

	public static Map<Long , Message> getMessages(){
		
		return messages;
	}
	
public static Map<String , Profile> getProfiles(){
		
		return profiles;
	}

}
