package com.easysolutions.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the friendlist database table.
 * 
 */
@Entity
@NamedQuery(name="Friendlist.findAll", query="SELECT f FROM Friendlist f")
public class Friendlist implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FriendlistPK id;

	public Friendlist() {
	}

	public FriendlistPK getId() {
		return this.id;
	}

	public void setId(FriendlistPK id) {
		this.id = id;
	}

}