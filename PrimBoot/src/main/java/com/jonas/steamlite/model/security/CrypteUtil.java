package com.jonas.steamlite.model.security;

import org.mindrot.jbcrypt.BCrypt;

public class CrypteUtil {

	public boolean checkPassword(String password, String hashWord) {
		
		boolean check = BCrypt.checkpw(password, hashWord);
		
		return check;
		
	}
	
	public String newSaltAndHach(String password) {
		
		String hashWord = BCrypt.hashpw(password, BCrypt.gensalt(12));
		
		return hashWord;
	}
	
}
