<jsp:include page='/MasterPageTopSection.jsp' />
<jsp:useBean id='notificationBean' scope='request'
class='com.thinking.machines.library.beans.NotificationBean' />
<h2>Notification</h2>
<div style='font-size:24pt'>
<b>${notificationBean.message}</b>
<br><br>
<form action='/${contextName}${notificationBean.actionURL}'>
<Button type='submit'>${notificationBean.actionText}</button>
</form>
</div>
<br>
<br>
<br>
<jsp:include page='/MasterPageBottomSection.jsp' />