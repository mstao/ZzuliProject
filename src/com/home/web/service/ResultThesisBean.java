package com.home.web.service;

import java.io.Serializable;

/**
 * 
* @ClassName: ResultThesisBean
* @Description: TODO 论文
* @author Mingshan
* @date 2017年4月11日 下午9:57:42
*
 */
public class ResultThesisBean implements Serializable{
	

	private static final long serialVersionUID = 680610041414411775L;
	
	private int id;
	private String style;
	private String author;
	private String name;
	private String publication_division;
	private String page_number;
	private String add_time;
	private int is_publish;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPublication_division() {
		return publication_division;
	}
	public void setPublication_division(String publication_division) {
		this.publication_division = publication_division;
	}
	public String getPage_number() {
		return page_number;
	}
	public void setPage_number(String page_number) {
		this.page_number = page_number;
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
