package com.thinking.machines.library.servlets;
import com.thinking.machines.library.dl.*;
import com.thinking.machines.library.beans.*;
import javax.servlet.http.*;
import javax.servlet.*;
public class UpdateAuthor extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
try
{
AuthorBean authorBean=(AuthorBean)request.getAttribute("authorBean");
AuthorDAO authorDAO=new AuthorDAO();
AuthorInterface author;
try
{
author=authorDAO.getByCode(authorBean.getCode());
}catch(DAOException daoException)
{
NotificationBean notificationBean;
notificationBean=new NotificationBean();
notificationBean.setMessage("That author cannot be updated as someone working in parallel deleted the author while you were trying to update it.");
notificationBean.setActionText("Edit other author");
notificationBean.setActionURL("/AuthorEditForm.jsp");
request.setAttribute("notificationBean",notificationBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/Notification.jsp");
requestDispatcher.forward(request,response);
return;
}
author.setName(authorBean.getName());
try
{
authorDAO.update(author);
NotificationBean notificationBean=new NotificationBean();
notificationBean.setMessage("Author : "+authorBean.getName()+" updated successfully.");
notificationBean.setActionText("Edit more authors");
notificationBean.setActionURL("/AuthorEditForm.jsp");
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
requestDispatcher=request.getRequestDispatcher("/AuthorUpdateForm.jsp");
requestDispatcher.forward(request,response);
}
}catch(Exception exception)
{
System.out.println(exception);
}
}
}