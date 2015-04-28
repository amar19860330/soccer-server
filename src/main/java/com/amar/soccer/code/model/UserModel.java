package com.amar.soccer.code.model;

public class UserModel extends BaseModel
{
	private String username;
	private String userpw;
	private String phone;
	private String email;
	
	/**
	 * 1男，2女
	 */
	private int sex;
	
	@Override
	public int [] toBytes()
	{
		return null;
	}
	@Override
	public int [] getDataLengh()
	{
		return new int[]{20,20,20,40};
	}
	
	public String getUsername()
	{
		return username;
	}
	public void setUsername( String username )
	{
		this.username = username;
	}
	public String getUserpw()
	{
		return userpw;
	}
	public void setUserpw( String userpw )
	{
		this.userpw = userpw;
	}
	public String getPhone()
	{
		return phone;
	}
	public void setPhone( String phone )
	{
		this.phone = phone;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail( String email )
	{
		this.email = email;
	}

	public int getSex()
	{
		return sex;
	}

	public void setSex( int sex )
	{
		this.sex = sex;
	}
}
