package com.home.web.service;

import java.io.Serializable;
/**
 * 
* @ClassName: FoundationbBean
* @Description: TODO 国家自然科学基金  
* @author Mingshan
* @date 2017年4月11日 下午9:24:45
*
 */

public class FoundationbBean implements Serializable{


	private static final long serialVersionUID = -277995993567936019L;
    
	private  int id;
	private  String name;
	private  String number;
	private  String person;
	private  double outlay;
	private  String time;
	private  String add_time;
	
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
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
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
