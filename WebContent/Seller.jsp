<%@page import="Model.Seller"%>
<%@page import ="javax.sql. *" %>
<%@page language="java" contentType ="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<% 

Seller seller = new Seller();
	String sellerGrid = "";
	String FeedBack = "";
	
	if(request.getParameter("hidMode") != null && request.getParameter("hidMode"). equalsIgnoreCase("save"))
	{
		FeedBack = seller.saveAnSeller(request.getParameter("txtSellerName"), request.getParameter("txtSellerDesc"), request.getParameter("txtSellerAddr"),request.getParameter("txtSellerPhone"));
	}
	
	if(request.getParameter("hidMode") != null && request.getParameter("hidMode"). equalsIgnoreCase("update"))
	{
		FeedBack = seller.updateAnSeller(request.getParameter("hidID"), request.getParameter("txtSellerName"),request.getParameter("txtSellerDesc"));

	}
	
	if(request.getParameter("hidMode") != null && request.getParameter("hidMode"). equalsIgnoreCase("remove"))
	{
		FeedBack = seller.deleteAnSeller(request.getParameter("hidID"));

	}
	
	sellerGrid = seller.getSeller();
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Seller Details</title>
<script type="text/javascript" src=Controllers/jquery-3.4.1.min.js></script>
<script type="text/javascript" src=Controllers/controller.js></script>
</head>
<body>

<form id="formSeller" action="items.jsp" method="post">
		<input id="hidMode" name="hidMode" type="hidden" value="save">
		<input id="hidID" name="hidID" type="hidden" value="0">
		Seller Name <input id="txtSellerName" type="text" name="txtSellerName"> <br>
		Seller Description <input id="txtSellerDesc" type="text" name="txtSellerDesc" > <br>
		Seller Address <input id="txtSellerAddr" type="text" name="txtSellerAddr"> <br>
		Seller Phone No <input id="txtSellerPhone" type="text" name="txtSellerPhone" > <br>
		<input id="btnSave" type="button" name="btnSave"  value="Save"> <br> <br>
		<div id="divStsMsgSeller"><% out.println(FeedBack); %> </div>
		<% out.println(sellerGrid); %> 
	</form> <br>
</body>
</html>