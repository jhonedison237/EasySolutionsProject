package com.easysolutions.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.easysolutions.model.Member;
import com.easysolutions.service.MemberService;

@Controller
@RequestMapping("/")
public class MemberController {
	
	@Autowired
	MessageSource messageSource;
	
	@Autowired
	MemberService memberService;

	@RequestMapping(value = { "/", "/listMembers" }, method = RequestMethod.GET)
	public String listClients(ModelMap model) {
		
		List<List<String>> friendList = memberService.getTotalFriendListByMember("jhonedison237@gmail.com");
		
		int i = 1;
		for (List<String> levelOfFriends : friendList) {
			System.out.println("***Level " + i + "***");
			i++;
			for (String friend : levelOfFriends) {
				System.out.println(friend);
			}
		}
		
		model.addAttribute("friendList", friendList);
		return "allFriendsList";
	}
	
	@RequestMapping(value = { "/searchAllFriends" }, method = RequestMethod.GET)
	public String searchAllFriends(ModelMap model) {
		Member member = new Member();
		model.addAttribute("member", member);
		return "searchAllFriends";
	}
	
	@RequestMapping(value = { "/searchAllFriends" }, method = RequestMethod.POST)
	public String allFriends(Member member, BindingResult result, ModelMap model) {

		List<List<String>> friendList = memberService.getTotalFriendListByMember(member.getMemEmail());

		model.addAttribute("friendList", friendList);
		return "allFriendsList";
	}
	
}