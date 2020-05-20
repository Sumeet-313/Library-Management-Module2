 <%@ taglib uri='/WEB-INF/tlds/CustomTags.tld' prefix='tm' %>
<jsp:include page='/MasterPageTopSection.jsp' />
<jsp:useBean id='bookBean' scope='request' class='com.thinking.machines.library.beans.BookBean' />
<jsp:useBean id='errorBean' scope='request' class='com.thinking.machines.library.beans.ErrorBean' />
<script src='/${contextName}/js/BookUpdateForm.js'></script>
<h2>Edit Book </h2>
<div class='error'>${errorBean.errorMessage}</div>
<form action='/${contextName}/UpdateBook.jsp' onsubmit='return validateForm(this)' method='post'>
<tm:FormId/>
<input type='hidden' id='code' name='code' value='${bookBean.code}' >
<table border='0'>
<tr>
<td>Title</td>
<td>
<input type='text' name='title' id='title' maxlength='35' size='31' value='${bookBean.title}'>
</td>
</tr>
<tr>
<td></td><td>
<span id='titleErrorSection' class='error'>&nbsp;</span>
</td>
</tr>
<tr>
<td>Author</td>
<td>
<select id='authorCode' name='authorCode'>
<option value='-1'>&lt;Select&gt;</option>
<tm:Author>
<tm:If expression='${bookBean.authorCode==code}'>
<option value='${code}' selected>${name}</option>
</tm:If>
<tm:If expression='${bookBean.authorCode!=code}'>
<option value='${code}'>${name}</option>
</tm:If>
</tm:Author>
</select>
</td>
</tr>
<tr>
<td></td><td>
<span id='authorCodeErrorSection' class='error'>&nbsp;</span>
</td>
</tr>
<tr>
<td>Category</td>
<td>
<select id='category' name='category'>
<option value='none'>&lt;Select&gt;</option>
<option value='Science fiction' ${(bookBean.category=="Science fiction")?"selected":""}>Science fiction</option>
<option value='Satire' ${(bookBean.category=="Satire")?"selected":""}>Satire</option>
<option value='Drama' ${(bookBean.category=="Drama")?"selected":""}>Drama</option>
<option value='Action and Adventure' ${(bookBean.category=="Action and Adventure")?"selected":""}>Action and Adventure</option>
<option value='Mystery' ${(bookBean.category=="Mystery")?"selected":""}>Mystery</option>
<option value='Horror' ${(bookBean.category=="Horror")?"selected":""}>Horror</option>
</select>
</td>
</tr>
<tr>
<td></td><td>
<span id='categoryErrorSection' class='error'>&nbsp;</span>
</td>
</tr>
<tr>
<td>Price</td>
<td>
<input type='text' name='price' id='price' maxlength='5' size='6' style='text-align:right' value='$
{bookBean.price}'>
</td>
</tr>
<tr>
<td></td><td>
<span id='priceErrorSection' class='error'>&nbsp;</span>
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