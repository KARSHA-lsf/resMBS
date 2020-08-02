package com.finnetwork.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "topic_mdl_30tpsample", catalog = "fin_network")
public class bubble_graph {
	@Id
	private int id;
	private String text;
	private double size;
	private int group;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public double getSize() {
		return size;
	}
	public void setSize(double size) {
		this.size = size;
	}
	public int getGroup() {
		return group;
	}
	public void setGroup(int group) {
		this.group = group;
	}
	@Override
	public String toString() {
		return "bubble_graph [id=" + id + ", text=" + text + ", size=" + size + ", group=" + group + "]";
	}
	
	
}
