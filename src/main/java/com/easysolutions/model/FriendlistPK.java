package com.easysolutions.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the friendlist database table.
 * 
 */
@Embeddable
public class FriendlistPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="frl_friend", insertable=false, updatable=false)
	private String frlFriend;

	@Column(name="frl_member", insertable=false, updatable=false)
	private String frlMember;

	public FriendlistPK() {
	}
	public String getFrlFriend() {
		return this.frlFriend;
	}
	public void setFrlFriend(String frlFriend) {
		this.frlFriend = frlFriend;
	}
	public String getFrlMember() {
		return this.frlMember;
	}
	public void setFrlMember(String frlMember) {
		this.frlMember = frlMember;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof FriendlistPK)) {
			return false;
		}
		FriendlistPK castOther = (FriendlistPK)other;
		return 
			this.frlFriend.equals(castOther.frlFriend)
			&& this.frlMember.equals(castOther.frlMember);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.frlFriend.hashCode();
		hash = hash * prime + this.frlMember.hashCode();
		
		return hash;
	}
}