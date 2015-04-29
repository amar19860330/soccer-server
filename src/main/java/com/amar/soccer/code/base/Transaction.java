package com.amar.soccer.code.base;

import com.amar.soccer.code.dao.BaseDao;
import com.amar.soccer.code.dao.LoginDao;
import com.amar.soccer.code.model.BaseModel;
import com.amar.soccer.code.model.UserModel;

public class Transaction<T extends BaseModel ,E extends BaseModel,V extends BaseDao>
{
	int businessType;
	
	public Class<T> requestClass;
	public Class<E> responseClass;
	public Class<V> daoClass;
	
	public void test()
	{
		try
		{
			requestClass.newInstance();
		}
		catch ( InstantiationException e )
		{
			e.printStackTrace();
		}
		catch ( IllegalAccessException e )
		{
			e.printStackTrace();
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}
	
	
	public static void main(String []args)
	{
		Transaction Transaction = new Transaction(1,UserModel.class,UserModel.class,LoginDao.class);
		Transaction.test();
	}
	public Transaction()
	{
		
	}
	
	public Transaction( int businessType , Class<T> requestClass , Class<E> responseClass ,Class<V> daoClass)
	{
		this.businessType = businessType;
		this.requestClass = requestClass;
		this.responseClass = responseClass;
		this.daoClass = daoClass;
	}
	
	public T getRequest()
	{
		T t = null;
		try
		{
			 t = requestClass.newInstance();
		}
		catch ( InstantiationException e )
		{
			e.printStackTrace();
		}
		catch ( IllegalAccessException e )
		{
			e.printStackTrace();
		}
		return t;
	}
	
	public E getresponse()
	{
		E el = null;
		try
		{
			el = responseClass.newInstance();
		}
		catch ( InstantiationException e )
		{
			e.printStackTrace();
		}
		catch ( IllegalAccessException e )
		{
			e.printStackTrace();
		}
		return el;
	}
	
	public V getDao()
	{
		V v = null;
		try
		{
			v = daoClass.newInstance();
		}
		catch ( InstantiationException e )
		{
			e.printStackTrace();
		}
		catch ( IllegalAccessException e )
		{
			e.printStackTrace();
		}
		return v;
	}
}
