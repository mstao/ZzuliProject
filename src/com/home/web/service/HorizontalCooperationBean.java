package com.home.web.service;

import java.io.Serializable;

/**
 * 
* @ClassName: HorizontalCooperation
* @Description: TODO 横向合作
* @author Mingshan
* @date 2017年4月11日 下午9:47:23
*
 */
public class HorizontalCooperationBean implements Serializable{

	private static final long serialVersionUID = -4333955807045720845L;
	
	
	
	private int id;
    private String name;
    private String cooperator;
    private String person;
    private double outlay;
    private String time;
    
    private String add_time;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCooperator() {
		return cooperator;
	}
	public void setCooperator(String cooperator) {
		this.cooperator = cooperator;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public double getOutlay() {
		return outlay;
	}
	public void setOutlay(double outlay) {
		this.outlay = outlay;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getAdd_time() {
		return add_time;
	}
	public void setAdd_time(String add_time) {
		this.add_time = add_time;
	}
    
    
}
