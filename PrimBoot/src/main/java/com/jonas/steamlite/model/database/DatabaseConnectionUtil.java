package com.jonas.steamlite.model.database;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class DatabaseConnectionUtil {


	
	private static SessionFactory sessionFactory;
	
	 static {
		try {
			sessionFactory = new Configuration()
				.configure("/com/jensen/steamlite/model/database/hibernate.cfg.xml")
				.buildSessionFactory();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public static void closeSessionFactory() {
		sessionFactory.close();
	}
		

}
