package com.home.web.service;

import java.io.Serializable;
/**
 * 
* @ClassName: ResultIdentificationBean
* @Description: TODO 鉴定 
* @author Mingshan
* @date 2017年4月11日 下午10:04:35
*
 */

public class ResultIdentificationBean implements Serializable{


	private static final long serialVersionUID = -3109223498552689144L;

	private int id;
	private String name;
	private String identification_number;
	private String person;
	private String time;
	private String level;
	private String add_time;
	private int is_publish;
	
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
	public String getIdentification_number() {
		return identification_number;
	}
	public void setIdentification_number(String identification_number) {
		this.identification_number = identification_number;
	}

	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getAdd_time() {
		return add_time;
	}
	public void setAdd_time(String add_time) {
		this.add_time = add_time;
	}
	public int getIs_publish() {
		return is_publish;
	}
	public void setIs_publish(int is_publish) {
		this.is_publish = is_publish;
	}
	
}
