package com.easysolutions.service;

import java.util.List;

import com.easysolutions.model.Member;

public interface MemberService {

	Member findByKey(String id);
	
	void saveMember(Member Member);
	
	void updateMember(Member Member);
	
	List<Member> findAllMembers();

	void deleteMemberByKey(String key);
	
	List<Member> findFriendsByMember(String key);

	List<String> getFriendsByMember(String memberKey);

	List<List<String>> getTotalFriendListByMember(String member);
	
}
