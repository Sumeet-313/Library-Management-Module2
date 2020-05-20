function deleteBook(bookCode,bookTitle)
{
var c=confrirm('Delete Book : '+bookTitle'+'('+booCode+')');
if(c)
{
var deleteBookForm=document.getElementById('deleteBookForm');
deleteBookForm.code.value=bookCode;
deleteBookForm.title.value=bookTitle;
deleteBookForm.submit();
}
}