package com.home.web.service;

import java.io.Serializable;

public class RulesBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String add_time;
	private Integer view_count;
	private Integer is_publish;
	private String rule_title;
	private String rule_content;
	private String author;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getRule_title() {
		return rule_title;
	}
	public void setRule_title(String rule_title) {
		this.rule_title = rule_title;
	}
	public String getRule_content() {
		return rule_content;
	}
	public void setRule_content(String rule_content) {
		this.rule_content = rule_content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	
}
