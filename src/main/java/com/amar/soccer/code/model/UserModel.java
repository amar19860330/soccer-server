package com.amar.soccer.code.model;

import com.amar.soccer.code.base.FCode;

public class UserModel extends BaseModel
{
	@FCode(index=1)
	private String username;
	@FCode(index=2)
	private String userpw;
	@FCode(index=3)
	private String phone;
	@FCode(index=4)
	private String email;
	
	/**
	 * 1男，2女
	 */
	@FCode(index=5)
	private int sex;

	
	public static void main( String [] args )
	{

	}
}
