package com.thinking.machines.library.beans;
public class ErrorBean implements java.io.Serializable
{
private String errorMessage;
public ErrorBean()
{
this.errorMessage="";
}
public void setErrorMessage(String errorMessage)
{
this.errorMessage=errorMessage;
}
public String getErrorMessage()
{
return this.errorMessage;
}
}