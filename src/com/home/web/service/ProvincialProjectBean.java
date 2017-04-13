package com.home.web.service;

import java.io.Serializable;
/**
 * 
* @ClassName: ProvincialProjectBean
* @Description: TODO 省部级重大（点）项目
* @author Mingshan
* @date 2017年4月11日 下午9:46:58
*
 */

public class ProvincialProjectBean implements Serializable{


	private static final long serialVersionUID = 4019907067079043414L;

	private int id;
	private String nameid;
	private String person;	
	private String source;	
	private double outlay;
	private String time;
	
	private String add_time;
	private int is_publish;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameid() {
		return nameid;
	}
	public void setNameid(String nameid) {
		this.nameid = nameid;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
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
	public int getIs_publish() {
		return is_publish;
	}
	public void setIs_publish(int is_publish) {
		this.is_publish = is_publish;
	}
	
	
}
