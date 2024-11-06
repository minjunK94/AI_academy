package com.lec.ex3insert;

import java.sql.*;
import java.util.*;

// 사용자에게 부서번호, 부서명, 부서위치를 입력 받아 insert
public class InsertDept {
	public static void main(String[] args) {
		String ur1 = "jdbc:oracle:thin:@localhost:1521:xe"; // 주소
		Scanner scanner = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		System.out.print("입력 하실 부서번호는 >");
		int deptno = scanner.nextInt();
		System.out.print("입력 하실 부서명은 >");
		String dname = scanner.next();
		System.out.print("입력 하실 부서위치는 >");
		String loc = scanner.next();
		String sql = String.format("INSERT INTO DEPT " 
			  + "  VALUES (%d, UPPER('%s'), UPPER('%s'))", deptno, dname, loc);
		try {
			conn = DriverManager.getConnection(ur1, "scott", "tiger");
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			System.out.println(result > 0 ? "입력 성공":"입력실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "SQL문 오류 또는 중복된 부서번호");
		}finally {
			try { //7 단계 연결해제
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}