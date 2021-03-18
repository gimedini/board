package goottgirls.web.board.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	private static final Logger logger = 
			LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("===== preHandle 호출");
		// login.jsp에서 form action="login-post"로 이동하기 전에
		// 데이터를 가로채서 세션에 그 정보를 저장
		String url = request.getParameter("targetUrl");
		logger.info("목적지 url : " + url);
		if(url != null && url != "") {
			request.getSession().setAttribute("dest", url);
		}
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("===== postHandle 호출");
		// model 객체의 loginResult 속성값(userid와 동일)을 확인
		// - null이 아니면(로그인 성공) session 객체에 loingId 속성 추가, 페이지 이동
		// - null이면(로그인 실패) 메인 페이지로 이동
		
		String loginId = (String) modelAndView.getModel()
				.get("loginResult");
		logger.info("loginId = " + loginId);
		if(loginId != null) {
			logger.info("로그인 성공");
			HttpSession session = request.getSession();
			session.setAttribute("loginId", loginId);
			
			// 세션에서 목적 url 가져오기
			String dest = (String) session.getAttribute("dest");
			if(dest != null) {
				response.sendRedirect(dest);
			} else {
				response.sendRedirect("/web/");
			}
		} else {
			logger.info("로그인 실패");
			HttpSession session = request.getSession();
			session.setAttribute("loginFail", "loginFail");
			response.sendRedirect("/web/member/login");
		}
		
		super.postHandle(request, response, handler, modelAndView);
	}
}














