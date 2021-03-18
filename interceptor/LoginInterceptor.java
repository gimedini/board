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
		logger.info("===== preHandle ȣ��");
		// login.jsp���� form action="login-post"�� �̵��ϱ� ����
		// �����͸� ����ä�� ���ǿ� �� ������ ����
		String url = request.getParameter("targetUrl");
		logger.info("������ url : " + url);
		if(url != null && url != "") {
			request.getSession().setAttribute("dest", url);
		}
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("===== postHandle ȣ��");
		// model ��ü�� loginResult �Ӽ���(userid�� ����)�� Ȯ��
		// - null�� �ƴϸ�(�α��� ����) session ��ü�� loingId �Ӽ� �߰�, ������ �̵�
		// - null�̸�(�α��� ����) ���� �������� �̵�
		
		String loginId = (String) modelAndView.getModel()
				.get("loginResult");
		logger.info("loginId = " + loginId);
		if(loginId != null) {
			logger.info("�α��� ����");
			HttpSession session = request.getSession();
			session.setAttribute("loginId", loginId);
			
			// ���ǿ��� ���� url ��������
			String dest = (String) session.getAttribute("dest");
			if(dest != null) {
				response.sendRedirect(dest);
			} else {
				response.sendRedirect("/web/");
			}
		} else {
			logger.info("�α��� ����");
			HttpSession session = request.getSession();
			session.setAttribute("loginFail", "loginFail");
			response.sendRedirect("/web/member/login");
		}
		
		super.postHandle(request, response, handler, modelAndView);
	}
}














