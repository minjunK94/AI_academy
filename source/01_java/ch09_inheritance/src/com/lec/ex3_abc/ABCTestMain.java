package com.lec.ex3_abc;

public class ABCTestMain {
	public static void main(String[] args) {
		S sobj = new S(); // 생성자 1개 실행
		S aobj = new A(); // 생성자 2개 실행 (S -> A)
		S bobj = new B();
		C cobj = new C();
		S[] arr = {sobj, aobj, bobj, cobj, new B()};
		for(S temp : arr) {
			System.out.println(temp.s);
		}
	}

}
