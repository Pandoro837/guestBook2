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

/**
 * Servlet implementation class GuestBookControllorer
 */
@WebServlet("/gbc")
public class GuestBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GuestBookDao guestBookDao = new GuestBookDao();
		
		//gbc 이하의 파라미터 값을 읽어서 구분한다
		String action = request.getParameter("action");
		
		switch(action){
		case "list":
			//리스트 가져오기
			List<GuestBookVo> guestBookList = guestBookDao.getList();
			
			//데이터를 어트리뷰트에 넣는다
			request.setAttribute("guestBookList", guestBookList);
			
			//jsp로 포워드
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/list.jsp");
			rd.forward(request, response);
			
			break;
		case "insert":
			break;
		case "deleteForm":
			break;
		case "delete":
			break;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
