package com.easysolutions.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easysolutions.dao.MemberDao;
import com.easysolutions.model.Member;
import com.easysolutions.service.MemberService;

@Service("MemberService")
@Transactional
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao dao;
	
	@Override
	public Member findByKey(String id) {
		return dao.findByKey(id);
	}

	@Override
	public void saveMember(Member Member) {
		dao.saveMember(Member);
	}

	@Override
	public void updateMember(Member member) {
		Member entity = dao.findByKey(member.getMemEmail());
		if (entity != null) {
			entity.setMemName(member.getMemName());
		}
	}

	@Override
	public List<Member> findAllMembers() {
		return dao.findAllMembers();
	}
	
	@Override
	public void deleteMemberByKey(String key) {
		dao.deleteMemberByKey(key);
	}

	@Override
	public List<Member> findFriendsByMember(String key) {
		return dao.findFriendsByMember(key);
	}
	
	@Override
	public List<String> getFriendsByMember(String memberKey) {
		return dao.getFriendsByMember(memberKey);
	}
	
	@Override
	public List<List<String>> getTotalFriendListByMember(String member) {
		List<List<String>> allFriends = new ArrayList<>(); 
		
		List<String> friendList = getFriendsByMember(member);
		allFriends.add(friendList);
		
		getFriendList(allFriends, friendList);
		
		return allFriends;
	}
	
	private void getFriendList(List<List<String>> allFriends, List<String> friendList) {
		
		List<String> newFriendList = new ArrayList<>();
		
		for (String member : friendList) {
			List<String> list = getFriendsByMember(member);
			newFriendList.addAll(list);
		}
		
		if (!newFriendList.isEmpty()) {
			allFriends.add(newFriendList);
			getFriendList(allFriends, newFriendList);			
		}
	}

}
