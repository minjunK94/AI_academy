package com.lec.ch12.service;

import com.lec.ch12.dao.PersonRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// pageNum파라미터 받아, startRow, enRow 계산후 => getPersonList(startRow, endRow)
		// pageCnt, startPage, endPage 계산후 view단으로 넘길 데이터 request에 setAtttribute
		// list.do or list.do?pageNum=
		String pageNum = request.getParameter("pageNum");
		if(pageNum==null || pageNum.equals("")) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum); // 숫자로 변환
		final int PAGESIZE=10, BLOCKSIZE=10;
		int startRow = (currentPage - 1) * PAGESIZE + 1;
		int endRow = startRow + PAGESIZE - 1;
		PersonRepository dao = PersonRepository.getInstance();
		request.setAttribute("personList", dao.getPersonList(startRow, endRow)); // 출력할 목록
		int totCnt = dao.getCount(); // 전체 DB 데이터 수
		int pageCnt = (int)Math.ceil((double)totCnt/PAGESIZE); // 전체 페이지 수
		int startPage = ((currentPage -1)/BLOCKSIZE)*BLOCKSIZE + 1;
		int endPage = startPage + BLOCKSIZE - 1;
		if(endPage > pageCnt) {
			endPage = pageCnt;
		}
		// view단에서 필요한 항목들을 request에 setAttribute
		request.setAttribute("BLOCKSIZE", BLOCKSIZE); // 이전을 출력하지 여부를 비교
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageNum", currentPage); // 현재 페이지 수
		request.setAttribute("pageCnt", pageCnt); // 다음을 출력할지 여부
	}

}