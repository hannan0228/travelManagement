package com.travel.spring_aop.code.common;

import com.travel.spring_aop.code.models.User;

public class LoginSession {
	protected static User loggedUser = null;

	public LoginSession() {
	}

	/**
	 * Create Session
	 * 
	 * @param user
	 */
	public static void createSession(User user) {
		loggedUser = user;
	}

	/**
	 * Get Login User
	 * 
	 * @return
	 */
	public static User getSession() {
		return loggedUser;
	}

	/**
	 * Check Login Status
	 * 
	 * @return
	 */
	public static boolean checkSession() {
		if (loggedUser != null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Log out from application
	 */
	public static void logout() {
		loggedUser = null;
	}
}
