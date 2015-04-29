package com.amar.soccer.code.base;

import java.util.HashMap;
import java.util.Map;

import com.amar.soccer.code.constant.Constant;

public class TransactionController
{
	public static Map<Integer,Transaction> transactionMap;
	
	static 
	{
		transactionMap = new HashMap<Integer,Transaction>();
		//transactionMap.put( Constant.Request_Login , new Transaction(Constant.Request_Login) );
	}
}
