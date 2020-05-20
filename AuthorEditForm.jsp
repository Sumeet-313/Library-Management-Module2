<%@ taglib uri='/WEB-INF/tlds/CustomTags.tld' prefix='tm' %>
<jsp:include page='/MasterPageTopSection.jsp' />
<jsp:useBean id='authorBean' scope='request'
class='com.thinking.machines.library.beans.AuthorBean' />
<jsp:useBean id='errorBean' scope='request' class='com.thinking.machines.library.beans.ErrorBean' />
<script src='/${contextName}/js/AuthorEditForm.js'></script>
<h2>Edit Author </h2>
<div class='error'>${errorBean.errorMessage}</div>
<form action='/${contextName}/EditAuthor.jsp' onsubmit='return validateForm(this)' method='post'>
<tm:FormId/>
<table border='0'>
<tr>
<td>Name of author</td>
<td>
<input type='text' name='name' id='name' maxlength='35' size='31' value='${authorBean.name}'>
</td>
</tr>
<tr>
<td colspan='2' align='right'>
<span id='nameErrorSection' class='error'>&nbsp;</span>
</td>
</tr>
<tr>
<td colspan='2' align='center'>
<button type='submit'>Edit</button>
</td>
</tr>
</table>
</form>
<br>
<br>
<br>
<jsp:include page='/MasterPageBottomSection.jsp' />