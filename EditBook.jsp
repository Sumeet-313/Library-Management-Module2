<jsp:useBean id='bookBean' scope='request' class='com.thinking.machines.library.beans.BookBean' />
<jsp:setProperty name='bookBean' property='*' />
<jsp:forward page='/editBook' />