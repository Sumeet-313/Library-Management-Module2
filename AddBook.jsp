<%@ taglib uri='/WEB-INF/tlds/CustomTags.tld' prefix='tm' %>
<tm:FormResubmitted>
<jsp:forward page='/Notification.jsp' />
</tm:FormResubmitted>
<jsp:useBean id='bookBean' scope='request' class='com.thinking.machines.library.beans.BookBean' />
<jsp:setProperty name='bookBean' property='*' />
<jsp:forward page='/addBook' />