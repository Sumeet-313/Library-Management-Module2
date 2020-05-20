package com.thinking.machines.library.beans;
public class BookBean implements java.io.Serializable,Comparable<BookBean>
{
private int code;
public String title;
private int authorCode;
private String category;
private int price;
public BookBean()
{
this.code=0;
this.title="";
this.authorCode=0;
this.category="";
this.price=0;
}
public void setCode(int code)
{
this.code=code;
}
public int getCode()
{
return this.code;
}
public void setTitle(String title)
{
this.title=title;
}
public String getTitle()
{
return this.title;
}
public void setAuthorCode(int authorCode)
{
this.authorCode=authorCode;
}
public int getAuthorCode()
{
return this.authorCode;
}
public void setCategory(String category)
{
this.category=category;
}
public String getCategory()
{
return this.category;
}
public void setPrice(int price)
{
this.price=price;
}
public int getPrice()
{
return this.price;
}
public boolean equals(Object object)
{
if(!(object instanceof BookBean)) return false;
BookBean otherBookBean=(BookBean) object;
return this.code==otherBookBean.code;
}
public int compareTo(BookBean otherBookBean)
{
return this.code-otherBookBean.getCode();
}
public int hashCode()
{
return this.code;
}


}