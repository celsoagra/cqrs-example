package me.celso.agra.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity
public class Information implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true)
	@NotNull
	private String content;

	public static Information newInstance(String msg) {
		return new Information(msg);
	}

	public Information(String msg) {
		this.content = msg;
	}
	
	public Information() {
	}

	public Long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
	

	protected void setId(Long id) {
		this.id = id;
	}

	protected void setContent(String content) {
		this.content = content;
	}

	@JsonIgnore
	public boolean isPersisted() {
		return Objects.nonNull(id);
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", content=" + content + "]";
	}
}
