<%@ taglib uri='/WEB-INF/tlds/CustomTags.tld' prefix='tm' %>
<jsp:include page='/MasterPageTopSection.jsp' />
<jsp:useBean id='authorBean' scope='request' class='com.thinking.machines.library.beans.AuthorBean' />
<jsp:useBean id='errorBean' scope='request' class='com.thinking.machines.library.beans.ErrorBean' />
<h2>Delete Author </h2>
<div class='error'>${errorBean.errorMessage}</div>
<form action='/${contextName}/DeleteAuthor.jsp' onsubmit='return validateForm(this)'
method='post'>
<tm:FormId/>
<input type='hidden' id='code' name='code' value='${authorBean.code}' >
<input type='hidden' id='name' name='name' value='${authorBean.name}' >
<table border='0'>
<tr>
<td>Code</td>
<td>
${authorBean.code}
</td>
</tr>
<tr>
<td>Name of author</td>
<td>
${authorBean.name}
</td>
</tr>
<tr>
<td colspan='2' align='center'>
<button type='submit'>Delete</button>
</td>
</tr>
</table>
</form>
<br>
<br>
<br>
<jsp:include page='/MasterPageBottomSection.jsp' />
