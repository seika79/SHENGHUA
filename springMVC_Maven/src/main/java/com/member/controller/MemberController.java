package com.member.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.member.dto.MemberDto;
import com.member.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	
	@RequestMapping(value="/member/write.do")
	public String memberWrite(){		
		return "member/write";
	}
	
	@RequestMapping(value="/member/writeAct.do")
	public String memberWriteAct(MemberDto dto) throws Exception{
		
		System.out.println("名前: "+dto.getUserName());
		System.out.println("ID: "+dto.getLoginId());
		System.out.println("パスワード: "+dto.getPswd());
		System.out.println("Email: "+dto.getEmail());	
		
		
		System.out.println(memberService);
		memberService.memberInsert(dto);
		System.out.println("会員登録完了");
		
		//ModelAndView mav = new ModelAndView();
		//mav.setViewName("member/writeResult");		
		//mav.addObject("dto", dto);
				
		return "redirect:/";
	}
	
	@RequestMapping(value="/member/login.do")
	public String memberLogin(){
		return "member/login";
	}
	
	@RequestMapping(value="/member/loginAct.do")
	public String memberLoginAct(MemberDto dto, HttpSession session) throws Exception{
		
//		MemberDto resultDto = memberService.memberLogin(dto);
//		System.out.println("로그인 아이디: "+resultDto.getLoginId());
//		if(resultDto == null || "".equals(resultDto)){
//			model.addAttribute("errMsg", "로그인 정보가 없거나, 로그인할 수 없습니다.");
//			return "member/login";
//		}else{
//			model.addAttribute("memberDto", resultDto);			
//			return "redirect:/";
//		}
		MemberDto resultDto = memberService.memberLogin(dto);
		if(resultDto == null || "".equals(resultDto)){
			session.removeAttribute("loginInfo");
			session.invalidate();
		}else{
			session.setAttribute("loginInfo", resultDto);
		}
		return "redirect:/";
	}
	
	@RequestMapping(value="/member/checkForm.do")
	public String memberCheckForm() {
		return "member/checkForm";
	}
	
	@RequestMapping(value="/member/idCheck.do")
	@ResponseBody
	public String idCheck(String loginId) throws Exception{
		
		String result = memberService.memberCheck(loginId);
		System.out.println("ID: "+result);
		
		String resultMsg = "";
		if(result == null|| "".equals(result)){
			// 해당 아이디는 사용하실 수 있는 아이디입니다.
			resultMsg = "入力した "+loginId+" IDは使用できません。 <input type=\"hidden\" id=\"idUseYn\" value=\"Y\" />";
		}else{
			
			// 해당 아이디는 사용하실 수 없습니다. 
			resultMsg = "入力した "+loginId+" IDは使用中です。他のIDを選択してください。 <input type=\"hidden\" id=\"idUseYn\" value=\"N\" />";
		}
		System.out.println(resultMsg);
		return resultMsg;
	}
	@RequestMapping(value="/member/logout.do")
	public String memberLogout(HttpSession session){
		session.invalidate();
		return "member/login";
	}
	
}
