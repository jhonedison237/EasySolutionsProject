package com.easysolutions.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

import org.hibernate.validator.constraints.NotEmpty;


/**
 * The persistent class for the member database table.
 * 
 */
@Entity
@NamedQuery(name="Member.findAll", query="SELECT m FROM Member m")
public class Member implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="mem_email")
	@NotEmpty
	private String memEmail;

	@Column(name="mem_name")
	@NotEmpty
	private String memName;
	
	//uni-directional many-to-many association to Member
	@ManyToMany//(fetch = FetchType.EAGER)
	@JoinTable(
		name="friendlist"
		, joinColumns={
			@JoinColumn(name="frl_member")
			}
		, inverseJoinColumns={
			@JoinColumn(name="frl_friend")
			}
		)
	private List<Member> friends;

	public Member() {
	}

	public String getMemEmail() {
		return this.memEmail;
	}

	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}

	public String getMemName() {
		return this.memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public List<Member> getFriends() {
		return friends;
	}

	public void setFriends(List<Member> friends) {
		this.friends = friends;
	}

}