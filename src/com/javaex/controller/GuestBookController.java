package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.GuestBookDao;
import com.javaex.vo.GuestBookVo;

@WebServlet("/gbc")
public class GuestBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		GuestBookDao guestBookDao = new GuestBookDao();
		
		//gbc 이하의 파라미터 값을 읽어서 구분한다
		String action = request.getParameter("action");
		
		if("addList".equals(action)){
			//리스트 가져오기
			List<GuestBookVo> guestBookList = guestBookDao.getList();
			
			//데이터를 어트리뷰트에 넣는다
			request.setAttribute("guestBookList", guestBookList);
			
			//확인용 출력
//				for(GuestBookVo guestInfo : guestBookList)
//					System.out.println(guestInfo);
			
			//jsp로 포워드
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/addList.jsp");
			rd.forward(request, response);
			
		} else if("insert".equals(action)) {
			//파라미터를 꺼낸다
			String name = request.getParameter("name");
			String pw = request.getParameter("pw");
			String content = request.getParameter("content");
			
			//Vo로 묶어준다
			GuestBookVo guestBookInsert = new GuestBookVo(name, pw, content);
			
			//dao - > 저장
			guestBookDao.insert(guestBookInsert);
			
			//리다이렉트
			response.sendRedirect("/guestbook2/gbc?action=addList");
			
		} else if("deleteForm".equals(action)) {
			//포워드로 보낸다
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/deleteForm.jsp");
			rd.forward(request, response);
			
		} else if("delete".equals(action)) {
			//no와 pw를 받는다
			int no = Integer.parseInt(request.getParameter("no"));
			String pw = request.getParameter("pw");
			
			guestBookDao.delete(pw, no);
			
			//리다이렉트
			response.sendRedirect("/guestbook2/gbc?action=addList");
		}	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
