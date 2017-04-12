package com.home.web.service;

import java.io.Serializable;
/**
 * 
* @ClassName: ResultPatentBean
* @Description: TODO 专利
* @author Mingshan
* @date 2017年4月11日 下午10:00:52
*
 */

public class ResultPatentBean implements Serializable{


	private static final long serialVersionUID = -5108865093754233748L;

	private int id;
	private String name;
	private String style;
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
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
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
