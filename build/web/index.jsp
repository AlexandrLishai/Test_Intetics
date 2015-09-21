<%-- 
    Document   : index
    Created on : 18.09.2015, 14:28:59
    Author     : Александр
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="beans.Client"%>
<%@page import="beans.ClientList"%>

<!DOCTYPE html>

<%@include file="WEB-INF/jspf/header.jspf" %>

<div>
    <div style="float: left;"><%@include file="WEB-INF/jspf/left_menu.jspf" %></div>
    <div><%@include file="WEB-INF/jspf/main.jspf" %></div> 
    
</div>
    
<%@include file="WEB-INF/jspf/footer.jspf" %>
