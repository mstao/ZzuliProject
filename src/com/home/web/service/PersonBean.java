package com.home.web.service;

import java.io.Serializable;

public class PersonBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String type_name;
	private Integer is_gugan;
	private String add_time;
	private Integer view_count;
	private Integer is_publish;
	private String person_name;
	private String avatar_file;
	private String person_post;
	private String person_info;
	private String author;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public Integer getIs_gugan() {
		return is_gugan;
	}
	public void setIs_gugan(Integer is_gugan) {
		this.is_gugan = is_gugan;
	}
	public String getAdd_time() {
		return add_time;
	}
	public void setAdd_time(String add_time) {
		this.add_time = add_time;
	}
	public Integer getView_count() {
		return view_count;
	}
	public void setView_count(Integer view_count) {
		this.view_count = view_count;
	}
	public Integer getIs_publish() {
		return is_publish;
	}
	public void setIs_publish(Integer is_publish) {
		this.is_publish = is_publish;
	}
	public String getPerson_name() {
		return person_name;
	}
	public void setPerson_name(String person_name) {
		this.person_name = person_name;
	}
	
	public String getAvatar_file() {
		return avatar_file;
	}
	public void setAvatar_file(String avatar_file) {
		this.avatar_file = avatar_file;
	}
	public String getPerson_post() {
		return person_post;
	}
	public void setPerson_post(String person_post) {
		this.person_post = person_post;
	}
	public String getPerson_info() {
		return person_info;
	}
	public void setPerson_info(String person_info) {
		this.person_info = person_info;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
}
