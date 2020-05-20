package com.thinking.machines.library.servlets;
import com.thinking.machines.library.beans.*;
import com.thinking.machines.library.dl.*;
import javax.servlet.http.*;
import javax.servlet.*;
public class AddAuthor extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
try
{
AuthorBean authorBean;
authorBean=(AuthorBean)request.getAttribute("authorBean");
AuthorInterface author=new Author();
author.setName(authorBean.getName());
AuthorDAO authorDAO=new AuthorDAO();
try
{
authorDAO.add(author);
authorBean.setCode(author.getCode());
NotificationBean notificationBean;
notificationBean=new NotificationBean();
notificationBean.setMessage("Author :"+authorBean.getName()+" added successfully.");
notificationBean.setActionText("Add more authors.");
notificationBean.setActionURL("/AuthorAddForm.jsp");
request.setAttribute("notificationBean",notificationBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/Notification.jsp");
requestDispatcher.forward(request,response);
}catch(DAOException daoException)
{
ErrorBean errorBean=new ErrorBean();
errorBean.setErrorMessage(daoException.getMessage());
request.setAttribute("errorBean",errorBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/AuthorAddFrom.jsp");
requestDispatcher.forward(request,response);
}
}catch(Exception exception)
{
System.out.println(exception);
}
}
}