package com.amar.soccer.code.dao;

import com.amar.soccer.code.model.BaseModel;


public abstract class BaseDao
{
	public abstract <T extends BaseModel> void request(T t);
	
	public abstract <T extends BaseModel>T response();
}
