<%@page import="com.sushant.login.dao.IdentityDAO"%>  
<jsp:useBean id="u" class="com.sushant.login.dto.UserDetailsdto"></jsp:useBean>    
<jsp:setProperty property="*" name="u"/>  
<%  
IdentityDAO.delete(u);  
response.sendRedirect("viewusers.jsp");  
%>  