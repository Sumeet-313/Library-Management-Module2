package com.thinking.machines.library.beans;
public class AuthorBean implements java.io.Serializable,Comparable<AuthorBean>
{
private int code;
public String name;
public AuthorBean()
{
this.code=0;
this.name="";
}
public void setCode(int code)
{
this.code=code;
}
public int getCode()
{
return this.code;
}
public void setName(String name)
{
this.name=name;
}
public String getName()
{
return this.name;
}
public boolean equals(Object object)
{
if(!(object instanceof AuthorBean)) return false;
AuthorBean otherAuthorBean=(AuthorBean)object;
return this.code==otherAuthorBean.code;
}
public int compareTo(AuthorBean otherAuthorBean)
{
return this.code-otherAuthorBean.getCode();
}
public int hashCode()
{

return this.code;
}
}