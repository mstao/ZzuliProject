package com.admin.util;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.admin.util.SessionManager;

public class SessionManagerListener implements HttpSessionListener {
	private SessionManager sessionManager = SessionManager.getInstance();
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		sessionManager.addSession(se.getSession()); 
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		sessionManager.deleteSession(se.getSession());
	}

}
