<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.qiniu.*,com.google.gson.JsonObject"%>
<%
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	response.setContentType("application/json");
	JsonObject jo = new JsonObject();
	jo.addProperty("token", Uptoken.makeUptoken());
	response.getWriter().print(jo.toString());
%>
