package com.thinking.machines.library.servlets;
import com.thinking.machines.library.beans.*;
import com.thinking.machines.library.dl.*;
import javax.servlet.http.*;
import javax.servlet.*;
public class GetAuthorForDeletion extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
try
{
AuthorBean authorBean;
authorBean=(AuthorBean)request.getAttribute("authorBean");
AuthorInterface author;
AuthorDAO authorDAO=new AuthorDAO();
try
{
author=authorDAO.getByName(authorBean.getName());
authorBean.setCode(author.getCode());
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/AuthorDeleteConfirmationForm.jsp");
requestDispatcher.forward(request,response);
}catch(DAOException daoException)
{
ErrorBean errorBean=new ErrorBean();
errorBean.setErrorMessage(daoException.getMessage());
request.setAttribute("errorBean",errorBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/AuthorDeleteForm.jsp");
requestDispatcher.forward(request,response);
}
}catch(Exception exception)
{
System.out.println(exception); // don't forget to remove after testing
}}}