package com.admin.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

public class SessionManager {
	private static SessionManager sessionManager;
    private Map<String, HttpSession> map;
    
    private SessionManager(){
        map = new HashMap<String, HttpSession>();
    }
    
    public static SessionManager getInstance(){
        if(sessionManager == null){
            sessionManager = new SessionManager();
        }
        return sessionManager;
    }
    public synchronized void addSession(HttpSession session){
        if (session != null) {
            map.put(session.getId(), session);
        }
    }
    public synchronized void deleteSession(HttpSession session){
        if (session != null) {
            map.remove(session.getId());
        }
    }
    public synchronized HttpSession getSession(String sessionId){
        if (sessionId == null) {
            return null;
        }
        return (HttpSession)map.get(sessionId);
    }
}
