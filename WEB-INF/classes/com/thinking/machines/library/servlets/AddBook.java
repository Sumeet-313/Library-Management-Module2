package com.thinking.machines.library.servlets;
import com.thinking.machines.library.beans.*;
import com.thinking.machines.library.dl.*;
import javax.servlet.http.*;
import javax.servlet.*;
public class AddBook extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
try
{
BookBean bookBean;
bookBean=(BookBean)request.getAttribute("bookBean");
BookInterface book=new Book();
book.setTitle(bookBean.getTitle());
book.setAuthorCode(bookBean.getAuthorCode());
book.setCategory(bookBean.getCategory());
book.setPrice(bookBean.getPrice());
BookDAO bookDAO=new BookDAO();
try
{
bookDAO.add(book);
bookBean.setCode(book.getCode());
NotificationBean notificationBean;
notificationBean=new NotificationBean();
notificationBean.setMessage("Book : "+bookBean.getTitle()+" added successfully.");
notificationBean.setActionText("Add more books");
notificationBean.setActionURL("/BookAddForm.jsp");
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
requestDispatcher=request.getRequestDispatcher("/BookAddForm.jsp");
requestDispatcher.forward(request,response);
}
}catch(Exception exception)
{
System.out.println(exception); // don't forget to remove after testing
}
}
}