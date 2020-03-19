<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="com.jquery.address.AddressVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.jquery.address.JAddressDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String field=request.getParameter("field");
	String word=request.getParameter("word");
	JAddressDAO jdao=JAddressDAO.getInstance();
	ArrayList<AddressVO> arr=jdao.getSearch(field,word);
	JSONArray jarr=new JSONArray();
	for(AddressVO av : arr){
		JSONObject obj=new JSONObject();
		obj.put("num", av.getNum());
		obj.put("name", av.getName());
		obj.put("zipcode", av.getZipcode());
		obj.put("addr", av.getAddr());
		obj.put("tel", av.getTel());
		jarr.add(obj);
	}
	out.println(jarr.toString());
	
	/* String str="검색결과 : \n";
	for(int i=0; i<arr.size(); i++){
		str+="\n번호 : "+arr.get(i).getNum();
		str+="\n이름 : "+arr.get(i).getName();
		str+="\n우편번호 : "+arr.get(i).getZipcode();
		str+="\n주소 : "+arr.get(i).getAddr();
		str+="\n전화번호 : "+arr.get(i).getTel();
		str+="\n";
	}
	out.println(str);*/
%>
