<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="com.jquery.address.ZipcodeVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.jquery.address.JAddressDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String dong=request.getParameter("dong");
	JAddressDAO jdao=JAddressDAO.getInstance();
	ArrayList<ZipcodeVO> arr=jdao.addressSearch(dong);
	JSONArray jarr=new JSONArray();
	for(ZipcodeVO z : arr){
		JSONObject obj=new JSONObject();
		obj.put("zipcode",z.getZipcode());
		obj.put("sido",z.getSido());
		obj.put("gugun",z.getGugun());
		obj.put("dong",z.getDong());
		obj.put("bunji",z.getBunji());
		jarr.add(obj);
	}
	out.println(jarr.toString());
%>