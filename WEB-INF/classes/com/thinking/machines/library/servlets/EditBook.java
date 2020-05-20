package com.thinking.machines.library.servlets;
import com.thinking.machines.library.beans.*;
import com.thinking.machines.library.dl.*;
import javax.servlet.http.*;
import javax.servlet.*;
public class EditBook extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
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
bookBean.setTitle(book.getTitle());
bookBean.setAuthorCode(book.getAuthorCode());
bookBean.setCategory(book.getCategory());
bookBean.setPrice(book.getPrice());
NotificationBean notificationBean;
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/BookUpdateForm.jsp");
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
}}}