package com.lec.ex01_janmuri;
class PersonInfo{
	private String name;
	private String tel;
	public PersonInfo(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}
	public String info() {
		return name + ":" + tel;
	}
}

public class Janmuri {
	public static void main(String[] args) {
		PersonInfo p = new PersonInfo("홍길동", "010-1234-5678");
		System.out.println(p.info());
	}
}
