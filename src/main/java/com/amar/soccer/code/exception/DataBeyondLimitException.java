package com.amar.soccer.code.exception;

public class DataBeyondLimitException extends Exception
{
	private static final long serialVersionUID = - 6009858855369790150L;

	public DataBeyondLimitException()
	{
		super("数据过大超过规定的范围");
	}
}
