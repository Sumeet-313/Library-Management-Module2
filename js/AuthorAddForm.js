function validateForm(frm)
{
var name=frm.name.value.trim();
var nameErrorSection=document.getElementById("nameErrorSection");
nameErrorSection.innerHTML="";
if(name.length==0)
{
nameErrorSection.innerHTML="Required";
frm.name.focus();
return false;
}
var validCharacters="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ .";
var e=0;
while(e<name.length)
{
if(validCharacters.indexOf(name.charAt(e))==-1)
{
nameErrorSection.innerHTML="Invalid characters in name of author";
frm.name.focus();
return false;
}
e++;
}
return true;
}