package com.thinking.machines.library.servlets;
import com.thinking.machines.library.beans.*;
import com.thinking.machines.library.dl.*;
import javax.servlet.http.*;
import javax.servlet.*;
public class DeleteBook extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
try
{
BookBean bookBean;
bookBean=(BookBean)request.getAttribute("bookBean");
BookDAO bookDAO=new BookDAO();
try
{
bookDAO.remove(bookBean.getCode());
NotificationBean notificationBean;
notificationBean=new NotificationBean();
notificationBean.setMessage("Book : "+bookBean.getTitle()+" deleted successfully.");
request.setAttribute("notificationBean",notificationBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/Books.jsp");
requestDispatcher.forward(request,response);
}catch(DAOException daoException)
{
ErrorBean errorBean=new ErrorBean();
errorBean.setErrorMessage(daoException.getMessage());
request.setAttribute("errorBean",errorBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/Books.jsp");
requestDispatcher.forward(request,response);
}
}catch(Exception exception)
{
System.out.println(exception); // don't forget to remove after testing
}
}
}