package goottgirls.web.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import goottgirls.web.board.domain.NoticeVO;
import goottgirls.web.board.pageutil.PageCriteria;
import goottgirls.web.board.pageutil.PageMaker;
import goottgirls.web.board.pageutil.SearchCriteria;
import goottgirls.web.board.persistence.NoticeDAO;
import goottgirls.web.board.service.NoticeService;

@Controller
@RequestMapping(value = "/notice")
public class NoticeController {
	private static final Logger logger =
			LoggerFactory.getLogger(NoticeController.class);
	
	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private NoticeDAO dao;
	
	@GetMapping("/list")
	public void list(Model model, @ModelAttribute("searchCriteria") SearchCriteria searchCriteria,
			Integer page, Integer perPage) throws Exception {
		logger.info("list 호출");
		logger.info("page = " + page + ", perPage = " + perPage);

	
	model.addAttribute("list", noticeService.list(searchCriteria));
	
	
	List<NoticeVO> list = noticeService.read(searchCriteria);
	model.addAttribute("noticeList", list);
	
	PageMaker maker = new PageMaker();
	maker.setCriteria(searchCriteria);
	maker.setTotalCount(noticeService.listCount(searchCriteria));
	maker.setPageData();
	model.addAttribute("pageMaker", maker);
	
	}
	
	
	@GetMapping("/register")
	public void registerGET() {
		logger.info("registerGET() 호출");
	} // end registerGET()
	
	@PostMapping("/register")
	public String registerPOST(NoticeVO vo, RedirectAttributes reAttr) {
		// RedirectAttributes 
		// - 재경로 위치에 속성값을 전송하는 객체
		logger.info("registerPOST() 호출");
		logger.info(vo.toString());
		int result = noticeService.create(vo);
		
		
		System.out.println();
		if(result == 1) { // DB insert 성공
			// "insert_result"의 키이름을 가진 데이터 전송 
			reAttr.addFlashAttribute("insert_result", "success");
			return "redirect:/notice/list"; // /notice/list 경로로 이동(get)방식
		} else { // DB insert 실패
			reAttr.addFlashAttribute("insert_result", "fail");
			return "redirect:/notice/list"; // /notice/register 경로로 이동
		}
	}
	
	@GetMapping("/detail")
	public void detailGET(int noticeNo, 
			Model model, 
			@ModelAttribute("page") int page,
			@ModelAttribute("searchCriteria") SearchCriteria searchCriteria) throws Exception {
		logger.info("detail() 호출 : no = " + noticeNo);
		
		NoticeVO vo;

			vo = noticeService.read(noticeNo);
			model.addAttribute("noticeVO", vo);
			
			model.addAttribute("searchCriteria", searchCriteria);
	

		
	}
	

	
	
	@GetMapping("/update")
	public void updateGET(int noticeNo, 
			Model model, 
			@ModelAttribute("page") int page,
			@ModelAttribute("searchCriteria") SearchCriteria searchCriteria) throws Exception {
		logger.info("update() 호출 : no = " + noticeNo);
		NoticeVO vo;
	
			vo = noticeService.read(noticeNo);
			model.addAttribute("noticeVO", vo);
			
			model.addAttribute("searchCriteria", searchCriteria);
	
	}
	
	@PostMapping("/update")
	public String updatePOST(NoticeVO vo, int page,
			@ModelAttribute("searchCriteria") SearchCriteria searchCriteria, RedirectAttributes rttr) throws Exception {
		logger.info("updatePOST() 호출 : no = " + vo.getNoticeNo());
		int result = noticeService.update(vo);
		
		rttr.addAttribute("page", searchCriteria.getPage());
		rttr.addAttribute("numsPerPage", searchCriteria.getNumsPerPage());
		rttr.addAttribute("searchType", searchCriteria.getSearchType());
		rttr.addAttribute("keyword", searchCriteria.getKeyword());
		
		if(result == 1) {
			return "redirect:/notice/list?page=" + page;
		} else {
			return "redirect:/notice/update?noticeNo=" + vo.getNoticeNo();
		}
	}
	
	@GetMapping("/delete")
	public String delete(int noticeNo, 
			@ModelAttribute("searchCriteria") SearchCriteria searchCriteria, RedirectAttributes rttr) throws Exception {
		logger.info("delete() 호출 : no = " + noticeNo);
		int result = noticeService.delete(noticeNo);
		
		rttr.addAttribute("page", searchCriteria.getPage());
		rttr.addAttribute("numsPerPage", searchCriteria.getNumsPerPage());
		rttr.addAttribute("searchType", searchCriteria.getSearchType());
		rttr.addAttribute("keyword", searchCriteria.getKeyword());
		
		if(result == 1) {
			return "redirect:/notice/list";
		} else {
			return "redirect:/notice/detail?noticeNo=" + noticeNo;
		}
	}

	
}
