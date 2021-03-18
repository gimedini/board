package goottgirls.web.board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping(value="/member")
public class KLoginController {
	private static final Logger logger = 
			LoggerFactory.getLogger(KLoginController.class);
	
	@GetMapping("/login")
	public void loginGet(String url, Model model) {
		logger.info("loginGet() ȣ��");
		logger.info("url : " + url); // ���� ���(�α����� ���� �Դ�)�� �� ���
		model.addAttribute("targetUrl",	url); // login.jsp�� url ���� ����		
	}
	
	@PostMapping("/login-post")
	public void loginPost(String userid, String password, Model model) throws IOException {
		logger.info("loginPost() ȣ��");
		String result = null;
		if(userid.equals("admin") && password.equals("1234")) {
			result = "admin"; // �α��� ������ ���̵� ����. �����ϸ� null

		} 
		logger.info("result : " + result);
		model.addAttribute("loginResult", result);
		

		
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest req) {
		logger.info("logout() ȣ��");
		
		HttpSession session = req.getSession();
		session.removeAttribute("loginId");
		
		return "redirect:/member/loginPage";
	}
	


}













