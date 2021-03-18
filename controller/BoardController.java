package goottgirls.web.board.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import goottgirls.web.board.domain.BoardVO;
import goottgirls.web.board.domain.CategoryVO;
import goottgirls.web.board.pageutil.PageCriteria;
import goottgirls.web.board.pageutil.PageMaker;
import goottgirls.web.board.pageutil.SearchCriteria;
import goottgirls.web.board.service.BoardService;
import net.sf.json.JSONArray;



@Controller
@RequestMapping(value ="/board") // url : /ex02/board/
public class BoardController {
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;
	

	
	@GetMapping("/list")
	public void list(Model model, @ModelAttribute("searchCriteria") SearchCriteria searchCriteria,
			 Integer page, Integer perPage) throws Exception {
		LOGGER.info("list 호출");
		LOGGER.info("page = " + page + ", perPage = " + perPage);
		
		model.addAttribute("list", boardService.listCount(searchCriteria));
		
		List<BoardVO> list = boardService.read(searchCriteria);
		for(BoardVO vo : list) {
			LOGGER.info(vo.toString());
		}
		model.addAttribute("boardList", list);
		
		PageMaker maker = new PageMaker();
		maker.setCriteria(searchCriteria);
		maker.setTotalCount(boardService.listCount(searchCriteria));
		maker.setPageData();
		model.addAttribute("pageMaker", maker);
	} // end list()
	
	@GetMapping("/register")
	public void registerGET(Model model) throws Exception {
		LOGGER.info("registerGET() 호출");
		
		List<CategoryVO> category = null;
		category = boardService.category();
		model.addAttribute("category", JSONArray.fromObject(category));
	} // end registerGET()
	
	@PostMapping("/register")
	public String registerPOST(Model model, BoardVO vo, RedirectAttributes reAttr) {
		// RedirectAttributes 
		// - 재경로 위치에 속성값을 전송하는 객체
		LOGGER.info("registerPOST() 호출");
		LOGGER.info(vo.toString());
		int result = boardService.create(vo);
		System.out.println();
		if(result == 1) { // DB insert 성공
			// "insert_result"의 키이름을 가진 데이터 전송 
			reAttr.addFlashAttribute("insert_result", "success");
			return "redirect:/board/list"; // /board/list 경로로 이동(get)방식
		} else { // DB insert 실패
			reAttr.addFlashAttribute("insert_result", "fail");
			return "redirect:/board/list"; // /board/register 경로로 이동
		}
	}
	
	@GetMapping("/detail")
	public void detailGET(int bno, 
			Model model, 
			@ModelAttribute("page") int page,
			@ModelAttribute("searchCriteria") SearchCriteria searchCriteria) throws Exception {
		LOGGER.info("detail() 호출 : bno = " + bno);
		BoardVO vo;
		
		vo = boardService.read(bno);
		model.addAttribute("boardVO", vo);
		model.addAttribute("searchCriteria", searchCriteria);
	}
	
	@GetMapping("/update")
	public void updateGET(int bno, 
			Model model, 
			@ModelAttribute("page") int page,
			@ModelAttribute("searchCriteria") SearchCriteria searchCriteria) throws Exception {
		LOGGER.info("update() 호출 : bno = " + bno);
		BoardVO vo;
		
		vo = boardService.read(bno);
		model.addAttribute("boardVO", vo);
		
		model.addAttribute("searchCriteria", searchCriteria);
	}
	
	@PostMapping("/update")
	public String updatePOST(BoardVO vo, int page,
			@ModelAttribute("searchCriteria") SearchCriteria searchCriteria, RedirectAttributes rttr) throws Exception {
		LOGGER.info("updatePOST() 호출 : bno = " + vo.getBno());
		int result = boardService.update(vo);
		
		rttr.addAttribute("page", searchCriteria.getPage());
		rttr.addAttribute("numsPerPage", searchCriteria.getNumsPerPage());
		rttr.addAttribute("searchType", searchCriteria.getSearchType());
		rttr.addAttribute("keyword", searchCriteria.getKeyword());
		
		if(result == 1) {
			return "redirect:/board/list?page=" + page;
		} else {
			return "redirect:/board/update?bno=" + vo.getBno();
		}
	}
	
	@GetMapping("/delete")
	public String delete(int bno, 
			@ModelAttribute("searchCriteria") SearchCriteria searchCriteria, RedirectAttributes rttr) throws Exception{
		LOGGER.info("delete() 호출 : bno = " + bno);

		int result = boardService.delete(bno);
		
		rttr.addAttribute("page", searchCriteria.getPage());
		rttr.addAttribute("numsPerPage", searchCriteria.getNumsPerPage());
		rttr.addAttribute("searchType", searchCriteria.getSearchType());
		rttr.addAttribute("keyword", searchCriteria.getKeyword());
		
		if(result == 1) {
			return "redirect:/board/list";
		} else {
			return "redirect:/board/detail?bno=" + bno;
		}
	}
	
}	












