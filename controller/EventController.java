package goottgirls.web.board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import goottgirls.web.board.domain.EventVO;
import goottgirls.web.board.pageutil.PageCriteria;
import goottgirls.web.board.pageutil.PageMaker;
import goottgirls.web.board.service.EventService;
import goottgirls.web.board.util.MediaUtil;
import goottgirls.web.board.util.UploadFileUtils;






@Controller
@RequestMapping(value = "/event") // url : /ex02/board/
public class EventController {
	private static final Logger LOGGER = 
	         LoggerFactory.getLogger(EventController.class);
	
	
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	@Autowired
	private EventService boardService;
	
	// @RequestMapping(value = "/list", method = RequestMethod.GET)
	@GetMapping("/list") // @RequestMapping 짧게 쓴것
	public void list(Model model, Integer page, Integer perPage) {
		LOGGER.info("list 호출");
		// 서버로 test 하는 방법 - console에 로고 찍히면 ok
		// http://localhost:8080/ex02/board/list
		LOGGER.info("page = " + page + ", perPage = " + perPage);
		// 이 두개를 받아와야 한다.
		
		// Paging 처리
		PageCriteria criteria = new PageCriteria();
		if(page != null) {
			criteria.setPage(page);
		}
		if(perPage != null) {
			criteria.setNumsPerPage(perPage);
		}
		List<EventVO> list = boardService.read(criteria);
		model.addAttribute("boardList", list);
		
		PageMaker maker = new PageMaker();
		maker.setCriteria(criteria);
		maker.setTotalCount(boardService.getTotalNumsOfRecords());;
		maker.setPageData();
		model.addAttribute("pageMaker", maker);
		
	} // end list()
	
	@GetMapping("/list_iframe") // @RequestMapping 짧게 쓴것
	public void list_iframe(Model model, Integer page, Integer perPage) {
		LOGGER.info("list_iframe 호출");
		// 서버로 test 하는 방법 - console에 로고 찍히면 ok
		// http://localhost:8080/ex02/board/list
		LOGGER.info("page = " + page + ", perPage = " + perPage);
		// 이 두개를 받아와야 한다.
		
		// Paging 처리
		PageCriteria criteria = new PageCriteria();
		if(page != null) {
			criteria.setPage(page);
		}
		if(perPage != null) {
			criteria.setNumsPerPage(perPage);
		}
		List<EventVO> list = boardService.read(criteria);
		model.addAttribute("boardList", list);
		
		PageMaker maker = new PageMaker();
		maker.setCriteria(criteria);
		maker.setTotalCount(boardService.getTotalNumsOfRecords());;
		maker.setPageData();
		model.addAttribute("pageMaker", maker);
		
	} // end list()
	
	@GetMapping("/register")
	public void registerGET() {
		LOGGER.info("registerGET() 호출");
	} // registerGET()
	
	// register버튼을 눌러서 등록을 하면 DB에 저장하면 끝	
	@PostMapping("/register")
	public String registerPOST(MultipartFile file, Model model, EventVO vo, RedirectAttributes reAttr) throws IOException, Exception {
		
//		String uploadFolder = "C:\\Study\\FileUploadTest";

		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		LOGGER.info("imgUploadPath = " + imgUploadPath);
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		LOGGER.info("ymdPath = " + ymdPath);
		String fileName = null;

		if(file != null) {
		 fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath); 
		 LOGGER.info("저장된 fileName = " + fileName);
		} else {
		 fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
		 LOGGER.info("실패한 fileName = " + fileName);
		}

		vo.setGdsImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		vo.setGdsThumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		

		
		
		// RedirectAttributes
		// - 재경로 위치에 속성값을 전송하는 객체
		// 데이터 유실 막기위한..
		
		LOGGER.info("registerPOST() 호출");
		LOGGER.info(vo.toString());
		// DB 저장
		int result = boardService.create(vo);
		
		// DB insert 성공하면 다른곳으로 이동
		if(result == 1) {
			// "insert_result"의 키이름을 가진 데이터 전송
			reAttr.addFlashAttribute("insert_result", "success");
			return "redirect:/event/list"; // /board/list 경로로 이동(get)방식
		} else { // DB insert 실패
			reAttr.addFlashAttribute("insert_result", "fail");
			return "redirect:/event/register"; // /board/register 경로로 이동(post)
		}
	} // end registerPOST()
	
	// a 링크이후, 1페이지내에서 글누르고, 목록누르면 1페이지로 돌아오는
	// (이전 정보를 가지고 있어야 한다) 
	@GetMapping("/detail")
	public void detailGET(int bno, 
			Model model,
			@ModelAttribute("page") Integer page, Integer perPage) { // 목록보기위해선 페이지 번호 필요
		LOGGER.info("detail() 호출 : bno = " + bno);
		EventVO vo = boardService.read(bno);
		model.addAttribute("boardVO", vo);
		

	}
	
	@GetMapping("/detail_iframe")
	public void detail_iframe(int bno, 
			Model model,
			@ModelAttribute("page") Integer page, Integer perPage) { // 목록보기위해선 페이지 번호 필요
		LOGGER.info("detail() 호출 : bno = " + bno);
		EventVO vo = boardService.read(bno);
		model.addAttribute("boardVO", vo);
		

	}

	
	// update
	@GetMapping("/update")
	public void updateGET(int bno, Model model, @ModelAttribute("page") int page) {
		LOGGER.info("update() 호출 : bno = " + bno);
		EventVO vo = boardService.read(bno); 
		model.addAttribute("boardVO", vo); // bno 값넘기기
	}
	
	@PostMapping("/update")
	public String updatePOST(EventVO vo, int page) {
		LOGGER.info("updatePOST() 호출 : bno = " + vo.getBno());
		int result = boardService.update(vo);
		
		if(result == 1) {
			return "redirect:/event/list?page=" + page; // /board/list 경로로 이동(get)방식
		} else {
			return "reditect:/event/update?bno=" + vo.getBno(); // /board/update?bno= 경로로 이동(post)방식
		}
	}
	
	// 삭
	@GetMapping("/delete")
	public String delete(int bno) {
		LOGGER.info("delete() 호출 : bno = " + bno);
		int result = boardService.delete(bno);
		if(result == 1) {
			return "redirect:/event/list";
		} else {
			return "redirect:/event/detail?bno=" + bno;
		}
	}
	
	@RequestMapping("display")
	public ResponseEntity<byte[]> display(String fileName) throws IOException {
		LOGGER.info("display() 호출");
		
		ResponseEntity<byte[]> entity = null;
		InputStream in = null;
		
		String filePath = uploadPath + fileName;
		in = new FileInputStream(filePath);
		
		// 파일 확장자
		String extension = 
				filePath.substring(filePath.lastIndexOf(".") + 1);
		LOGGER.info("파일 확장자 : " + extension);
		
		// 응답 헤더(response header)에 Content-Type 설정
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaUtil.geMediaType(extension));

		
		// 데이터 전송
		entity = new ResponseEntity<byte[]> (
					IOUtils.toByteArray(in), // 파일에서 읽은 데이터
					httpHeaders, // 응답 헤더
					HttpStatus.OK
				);

		return entity;
	}
	
	private String saveUploadFile(MultipartFile file) {
		// UUID : 업로드하는 파일 이름이 중복되지 않도록
		UUID uuid = UUID.randomUUID();
		String savedName = uuid + "_" + file.getOriginalFilename();
		File target = new File(uploadPath, savedName); // 저장할 파일 객체 생성
		
		try {
			FileCopyUtils.copy(file.getBytes(), target);
			LOGGER.info("파일 저장 성공");
			return savedName;
		} catch (IOException e) {
			LOGGER.error("파일 저장 실패");
			return null;
		}
		
	}
	
} // end BoardController
