package com.thinking.machines.library.servlets;
import com.thinking.machines.library.beans.*;
import com.thinking.machines.library.dl.*;
import javax.servlet.http.*;
import javax.servlet.*;
public class DeleteAuthor extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
AuthorBean authorBean=(AuthorBean)request.getAttribute("authorBean");
BookDAO bookDAO=new BookDAO();
try
{
boolean bookWithAuthorExists=bookDAO.containsBookWithAuthorCode(authorBean.getCode());
if(bookWithAuthorExists)
{
ErrorBean errorBean=new ErrorBean();
errorBean.setErrorMessage("Cannot delete author as book exists against it.");
request.setAttribute("errorBean",errorBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/AuthorDeleteForm.jsp");
requestDispatcher.forward(request,response);
return;
}
}catch(DAOException daoException)
{
System.out.println(daoException); // don't forget to remove after testing
}
catch(Exception exception)
{
System.out.println(exception); // don't forget to remove after testing
}
try
{
AuthorDAO authorDAO=new AuthorDAO();
try
{
authorDAO.remove(authorBean.getCode());
}catch(DAOException daoException)
{
System.out.println(daoException); // don't forget to remove after testing
}
NotificationBean notificationBean;
notificationBean=new NotificationBean();
notificationBean.setMessage("Author : "+authorBean.getName()+" deleted successfully.");
notificationBean.setActionText("Delete more authors");
notificationBean.setActionURL("/AuthorDeleteForm.jsp");
request.setAttribute("notificationBean",notificationBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/Notification.jsp");
requestDispatcher.forward(request,response);
}catch(Exception exception)
{
System.out.println(exception); // don't forget to remove after testing
}
}
}