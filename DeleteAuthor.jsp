<%@ taglib uri='/WEB-INF/tlds/CustomTags.tld' prefix='tm' %>
<tm:FormResubmitted>
<jsp:forward page='/Notification.jsp' />
</tm:FormResubmitted>
<jsp:useBean id='authorBean' scope='request'
class='com.thinking.machines.library.beans.AuthorBean' />
<jsp:setProperty name='authorBean' property='*' />
<jsp:forward page='/deleteAuthor' />