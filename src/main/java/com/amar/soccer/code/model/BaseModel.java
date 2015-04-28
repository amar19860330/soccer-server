package com.amar.soccer.code.model;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amar.soccer.code.base.FCode;
import com.amar.soccer.code.constant.Constant;
import com.amar.soccer.code.util.DataTrans;

/**
 * 通信时数据分为两部分，<BR/>
 * 第一部分，数据头部分：
 * 第一个4位标识soccer通信标记，
 * 接下来4位标识数据总长度
 * 接下来4位标识通信类型，如：登录，登出等,
 * 接下来4位标识是客户端发起，还是服务端回应,
 * 接下来4位标识是需要广播，还是点对点的通信
 * 接下来4位标识是否需要登录<BR/>
 * 第二部分，数据：
 * 4位长度，数据
 * 4位长度，数据
 * ... ...
 */
public abstract class BaseModel
{
	/**
	 * 本程序的识别号
	 * 
	 * @see com.amar.soccer.code.constant.Constant
	 */
	private int appSign = Constant.App_Sign;

	/**
	 * @return 表示是需要广播，还是点对点的通信
	 * @see com.amar.soccer.code.constant.Constant
	 */
	private int noticeType;

	/**
	 * @return 表示是客户端发起，还是服务端回应
	 * @see com.amar.soccer.code.constant.Constant
	 */
	private int sendType;

	/**
	 * @return 通信类型，如：登录，登出等;
	 * @see com.amar.soccer.code.constant.Constant
	 */
	private int businessType;

	/**
	 * 是否需要登录才能通信
	 * 
	 * @see com.amar.soccer.code.constant.Constant
	 */
	private int needLogin;

	/**
	 * 除去头两个4位的标志位之后所有数据的总长度
	 */
	private int totalLength;

	private Map<Integer,Field> getFieldMap()
	{
		Map<Integer,Field> fieldMap = new HashMap<Integer,Field>();
		Field [] allFields = this.getClass().getDeclaredFields();
		if ( allFields != null )
		{
			for( Field field : allFields )
			{
				if ( ! field.isAnnotationPresent( FCode.class ) )
				{
					continue;
				}
				if ( ! field.isAccessible() )
				{
					field.setAccessible( true );
				}
				FCode fCode = field.getAnnotation( FCode.class );
				int index = fCode.index();
				fieldMap.put( index , field );
			}
		}
		return fieldMap;
	}

	public byte [] toBytes()
	{
		Map<Integer,Field> fieldMap = getFieldMap();
		byte [] result = null;

		if ( fieldMap != null && fieldMap.size() > 0 )
		{
			for( int index = 1 ; index < fieldMap.size() ; index ++ )
			{
				try
				{
					Field field = fieldMap.get( index );
					byte [] fieldData = null;
					if ( field.getType() == String.class )
					{
						String fieldValue = "";
						if ( field.get( this ) != null )
						{
							fieldValue = field.get( this ).toString();
						}
						fieldData = fieldValue.getBytes( Constant.App_Code );
					}
					else if ( field.getType() == Integer.class )
					{
						fieldData = DataTrans.intToByte4( field.getInt( this ) );
					}

					byte [] sizeArray = DataTrans.intToByte4( fieldData.length );
					if ( result == null )// 第一次循环
					{
						result = DataTrans.connectAB( sizeArray , fieldData );
					}
					else
					{
						DataTrans.connectAB( result , DataTrans.connectAB( sizeArray , fieldData ) );
					}
				}
				catch ( UnsupportedEncodingException e )
				{
					e.printStackTrace();
				}
				catch ( IllegalArgumentException e )
				{
					e.printStackTrace();
				}
				catch ( IllegalAccessException e )
				{
					e.printStackTrace();
				}
			}
		}

		return result;
	}

	public void fromBytes( byte [] originBytes )
	{
		Map<Integer,Field> fieldMap = getFieldMap();
		
		if ( fieldMap == null || fieldMap.size() < 1 || originBytes.length<4)
		{
			return;
		}
		
		for( int index = 1 ; index < fieldMap.size() ; index ++ )
		{
			Field field = fieldMap.get( index );
			
			if ( field.getType() == String.class )
			{
			//TODO	
			}
			else if ( field.getType() == Integer.class )
			{
				//TODO
			}
		}
	}

	public int getTotalLength()
	{
		return totalLength;
	}

	public void setTotalLength( int totalLength )
	{
		this.totalLength = totalLength;
	}

	public int getAppSign()
	{
		return appSign;
	}

	public void setAppSign( int appSign )
	{
		this.appSign = appSign;
	}

	public int getNoticeType()
	{
		return noticeType;
	}

	public void setNoticeType( int noticeType )
	{
		this.noticeType = noticeType;
	}

	public int getSendType()
	{
		return sendType;
	}

	public void setSendType( int sendType )
	{
		this.sendType = sendType;
	}

	public int getBusinessType()
	{
		return businessType;
	}

	public void setBusinessType( int businessType )
	{
		this.businessType = businessType;
	}

	public int getNeedLogin()
	{
		return needLogin;
	}

	public void setNeedLogin( int needLogin )
	{
		this.needLogin = needLogin;
	}

}
