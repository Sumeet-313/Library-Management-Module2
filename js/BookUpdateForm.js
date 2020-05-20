function validateForm(frm)
{
var title=frm.title.value.trim();
var titleErrorSection=document.getElementById('titleErrorSection');
titleErrorSection.innerHTML='&nbsp;';
var authorCode=frm.authorCode.value;
var authorCodeErrorSection=document.getElementById('authorCodeErrorSection');
authorCodeErrorSection.innerHTML='&nbsp;';
var category=frm.category.value;
var categoryErrorSection=document.getElementById('categoryErrorSection');
categoryErrorSection.innerHTML='&nbsp;';
var price=frm.price.value.trim();
var priceErrorSection=document.getElementById('priceErrorSection');
priceErrorSection.innerHTML='&nbsp;';
var errorComponent=null;
var valid=true;
if(title.length==0)
{
titleErrorSection.innerHTML="Required";
valid=false;
errorComponent=frm.title;
}
if(authorCode==-1)
{
authorCodeErrorSection.innerHTML="Required";
valid=false;
if(errorComponent==null)
{
errorComponent=frm.authorCode;
}}
if(category=='none')
{
categoryErrorSection.innerHTML="Required";
valid=false;
if(errorComponent==null)
{
errorComponent=frm.category;
}}
if(price.length==0)
{
frm.price.value="0";
}
v="0123456789";
var i=0;
while(i<price.length)
{
if(v.indexOf(price.charAt(i))==-1)
{
priceErrorSection.innerHTML="Invalid";
valid=false;
if(errorComponent==null)
{
errorComponent=frm.price;
}
break;
}
i++;
}
if(!valid) errorComponent.focus();
return valid;
}