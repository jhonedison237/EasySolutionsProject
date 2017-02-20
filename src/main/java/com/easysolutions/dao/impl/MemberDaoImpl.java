package com.easysolutions.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.easysolutions.dao.AbstractDao;
import com.easysolutions.dao.MemberDao;
import com.easysolutions.model.Member;

@Repository("MemberDao")
public class MemberDaoImpl extends AbstractDao<String, Member> implements MemberDao {

	@Override
	public Member findByKey(String key) {
		return getByKey(key);
	}

	@Override
	public void saveMember(Member member) {
		persist(member);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Member> findAllMembers() {
		Criteria criteria = createEntityCriteria();
		return (List<Member>) criteria.list();
	}

	@Override
	public void deleteMemberByKey(String key) {
		Member Member = findByKey(key);
		delete(Member);
	}

	@Override
	public List<Member> findFriendsByMember(String key) {
		Member member = findByKey(key);
		
		List<Member> members = member.getFriends();
		
		return members;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<String> getFriendsByMember(String memberKey) {
		
		Member member = findByKey(memberKey);
		
		String hql = "SELECT fr.id.frlFriend FROM Friendlist fr WHERE fr.id.frlMember = :member";
	    Query query = getSession().createQuery(hql);
	    query.setString("member", member.getMemEmail());
		List<String> members = query.list();
		
		return members;
	}
	
}
