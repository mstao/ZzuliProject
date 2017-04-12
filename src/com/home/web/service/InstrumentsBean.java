package com.home.web.service;

import java.io.Serializable;

public class InstrumentsBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer is_publish;
	private String instrument_name;
	private String instrument_image;
	private String instrument_url;
	private String instrument_info;
	private int view_count;
	private String author;
	private String add_time;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIs_publish() {
		return is_publish;
	}
	public void setIs_publish(Integer is_publish) {
		this.is_publish = is_publish;
	}
	public String getInstrument_name() {
		return instrument_name;
	}
	public void setInstrument_name(String instrument_name) {
		this.instrument_name = instrument_name;
	}
	public String getInstrument_image() {
		return instrument_image;
	}
	public void setInstrument_image(String instrument_image) {
		this.instrument_image = instrument_image;
	}
	public String getInstrument_url() {
		return instrument_url;
	}
	public void setInstrument_url(String instrument_url) {
		this.instrument_url = instrument_url;
	}
	public String getInstrument_info() {
		return instrument_info;
	}
	public void setInstrument_info(String instrument_info) {
		this.instrument_info = instrument_info;
	}
	public int getView_count() {
		return view_count;
	}
	public void setView_count(int view_count) {
		this.view_count = view_count;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getAdd_time() {
		return add_time;
	}
	public void setAdd_time(String add_time) {
		this.add_time = add_time;
	}
	
	
}
