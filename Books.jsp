<%@ taglib uri='/WEB-INF/tlds/CustomTags.tld' prefix='tm' %>
<jsp:useBean id='notificationBean' scope='request'
class='com.thinking.machines.library.beans.NotificationBean' />
<jsp:useBean id='errorBean' scope='request' class='com.thinking.machines.library.beans.ErrorBean' />
<jsp:include page='/MasterPageTopSection.jsp' />
<script src='/${contextName}/js/Books.js'></script>
<h2>Books</h2>
<tm:If expression='${notificationBean.message!=""}'>
<h3>${notificationBean.message}</h3>
</tm:If>
<div class='error'>${errorBean.errorMessage}</div>
<table class='book-list'>
<thead>
<tr>
<th>S.No.</th>
<th>Title</th>
<th>Code</th>
<th>Author</th>
<th>Category</th>
<th>Price</th>
<th></th>
<th></th>
</tr>
</thead>
<tbody>
<tm:Book>
<tm:If expression='${evenRow}'>
<tr class='evenRow'>
</tm:If>
<tm:If expression='${oddRow}'>
<tr class='oddRow'>
</tm:If>
<td>${serialNumber}</td>
<td>${title}</td>
<td>${code}</td>
<td>${authorName}</td>
<td>${category}</td>
<td>${price}</td>
<td><a href='/${contextName}/EditBook.jsp?code=${code}'><img src='/$
{contextName}/images/edit_icon.png' style='padding:5px'></a></td>
<td><a href='javascript:deleteBook(${code},"${title}")'><img src='/$
{contextName}/images/delete_icon.png' style='padding:5px'></a></td>
</tr>
</tm:Book>
</tbody>
</table>
<form id='deleteBookForm' action='/${contextName}/DeleteBook.jsp' method='POST'>
<tm:FormId/>
<input type='hidden' name='code' id='code'>
<input type='hidden' name='title' id='title'>
</form>
<br>
<br>
<br>
<jsp:include page='/MasterPageBottomSection.jsp' />