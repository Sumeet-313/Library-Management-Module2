<%@ taglib uri='/WEB-INF/tlds/CustomTags.tld' prefix='tm' %>
<jsp:include page='/MasterPageTopSection.jsp' />
<jsp:useBean id='authorBean' scope='request' class='com.thinking.machines.library.beans.AuthorBean' />
<jsp:useBean id='errorBean' scope='request' class='com.thinking.machines.library.beans.ErrorBean' />
<script src='/${contextName}/js/AuthorUpdateForm.js'></script>
<h2>Edit Author </h2>
<div class='error'>${errorBean.errorMessage}</div>
<form action='/${contextName}/UpdateAuthor.jsp' onsubmit='return validateForm(this)'
method='post'>
<tm:FormId/>
<input type='hidden' name='code' id='code' value='${authorBean.code}'>
<table border='0'>
<tr>
<td>Code</td>
<td>
<b>${authorBean.code}</b>
</td>
</tr>
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
<button type='submit'>Update</button>
</td>
</tr>
</table>
</form>
<br>
<br>
<br>
<jsp:include page='/MasterPageBottomSection.jsp' />

