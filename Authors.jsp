<%@ taglib uri='/WEB-INF/tlds/CustomTags.tld' prefix='tm' %>
<jsp:include page='/MasterPageTopSection.jsp' />
<h2>Authors</h2>
<table class='author-list'>
<thead>
<tr>
<th>S.No.</th>
<th>Author</th>
<th>Code</th>
</tr>
</thead>
<tbody>
<tm:Author>
<tm:If expression='${evenRow}'>
<tr class='evenRow'>
</tm:If>
<tm:If expression='${oddRow}'>
<tr class='oddRow'>
</tm:If>
<td>${serialNumber}</td>
<td>${name}</td>
<td>${code}</td>
</tr>
</tm:Author>
</tbody>
</table>
<br>
<br>
<br>
<jsp:include page='/MasterPageBottomSection.jsp' />