package com.thinking.machines.library.beans;
public class NotificationBean implements java.io.Serializable
{
private String message;
private String actionText;
private String actionURL;
public NotificationBean()
{
this.message="";
}
public void setMessage(String message)
{
this.message=message;
}
public String getMessage()
{
return this.message;
}
public void setActionText(String actionText)
{
this.actionText=actionText;
}
public String getActionText()
{
return this.actionText;
}
public void setActionURL(String actionURL)
{
this.actionURL=actionURL;
}
public String getActionURL()
{
return this.actionURL;
}
}