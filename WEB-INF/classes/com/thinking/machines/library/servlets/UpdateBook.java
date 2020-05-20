package com.thinking.machines.library.servlets;
import com.thinking.machines.library.beans.*;
import com.thinking.machines.library.dl.*;
import javax.servlet.http.*;
import javax.servlet.*;
public class UpdateBook extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
try
{
BookBean bookBean;
bookBean=(BookBean)request.getAttribute("bookBean");
BookInterface book;
BookDAO bookDAO=new BookDAO();
try
{
book=bookDAO.getByCode(bookBean.getCode());
book.setTitle(bookBean.getTitle());
book.setAuthorCode(bookBean.getAuthorCode());
book.setCategory(bookBean.getCategory());
book.setPrice(bookBean.getPrice());
}catch(DAOException daoException)
{
ErrorBean errorBean=new ErrorBean();
errorBean.setErrorMessage("That book cannot be updated as someone working in parallel book while you were trying to update it.");
request.setAttribute("errorBean",errorBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/Books.jsp");
requestDispatcher.forward(request,response);
return;
}
try
{
bookDAO.update(book);
NotificationBean notificationBean;
notificationBean=new NotificationBean();
notificationBean.setMessage("Book : "+bookBean.getTitle()+" updated successfully.");
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
requestDispatcher=request.getRequestDispatcher("/BookUpdateForm.jsp");
requestDispatcher.forward(request,response);
}
}catch(Exception exception)
{
System.out.println(exception); // don't forget to remove after testing
}}}