package com.lec.ex1_store;

public class Store2 extends HeadQuarterStore {

	public Store2(String storeName) {
		super(storeName);
	}
	public String toString() {
		return "＠" + getStoreName() + "@";
	}
	@Override
	public void kimchi() {
		System.out.println("김치찌개 8,000원");}
	@Override
	public void bibim() {
		System.out.println("비빔밥 89,000원");}
	@Override
	public void bude() {
		System.out.println("부재찌개 48,000원");}
	@Override
	public void sunde() {
		System.out.println("순대국 안 팔아");}
	@Override
	public void gongi() {
		System.out.println("공기밥 1,000원");}

}