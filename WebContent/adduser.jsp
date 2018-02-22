<%@page import="com.sushant.login.dao.IdentityDAO"%>  
<jsp:useBean id="u" class="com.sushant.login.dto.UserDetailsdto"></jsp:useBean>  
<jsp:setProperty property="*" name="u"/>  
  
<%  
int i=IdentityDAO.create(u);  
if(i>0){  
response.sendRedirect("adduser-success.jsp");  
}else{  
response.sendRedirect("adduser-error.jsp");  
} 
%> 