package com.home.web.service;

import java.io.Serializable;

/**
 * 
* @ClassName: ResultRewardsBean
* @Description: TODO 奖励
* @author Mingshan
* @date 2017年4月11日 下午9:50:39
*
 */

public class ResultRewardsBean implements Serializable{
	

	private static final long serialVersionUID = -942734209466624489L;
	
	private int id;
	private String name;
	private String awards;
	private String person;
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
	public String getAwards() {
		return awards;
	}
	public void setAwards(String awards) {
		this.awards = awards;
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
	public String getAdd_time() {
		return add_time;
	}
	public void setAdd_time(String add_time) {
		this.add_time = add_time;
	}
	
	
}
