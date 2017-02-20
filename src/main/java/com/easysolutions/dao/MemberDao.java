package com.easysolutions.dao;

import java.util.List;

import com.easysolutions.model.Member;

public interface MemberDao {

	Member findByKey(String key);

	void saveMember(Member Member);
	
	List<Member> findAllMembers();

	void deleteMemberByKey(String id);
	
	List<Member> findFriendsByMember(String member);

	List<String> getFriendsByMember(String memberKey);

}
