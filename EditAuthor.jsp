<jsp:useBean id='authorBean' scope='request' class='com.thinking.machines.library.beans.AuthorBean' />
<jsp:setProperty name='authorBean' property='*' />
<jsp:forward page='/editAuthor' />