package com.amar.soccer.code.model;

import com.amar.soccer.code.constant.Constant;

/**
 * 通信时<BR/>
数据分为两部分，
第一部分，数据头部分：
第一个4位标识soccer通信标记，
第二个4位标识通信类型，如：登录，登出等,
接下来1位标识是客户端发起，还是服务端回应,
接下来1位标识是需要广播，还是点对点的通信
接下来1位标识是否需要登录

第二部分，数据：

 *
 */
public abstract class BaseModel
{
	/**
	 * 本程序的识别号
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
	 * @see com.amar.soccer.code.constant.Constant
	 */
	private int needLogin;
	
	/**
	 * @return 规定数据中各个字段的长度
	 */
	public abstract int [] getDataLengh();

	public abstract int [] toBytes();
	/**
	 * 计算总长度<BR/>
	 */
	public int [] computerLength(BaseModel baseModel)
	{
		int dataLength = baseModel.getDataLengh() == null ? 0 : baseModel.getDataLengh().length;
		int pre = 5;//必须的5种通信标识
		int [] totalLength = new int [ pre + dataLength ];
		totalLength[ 0 ] = 4;
		totalLength[ 1 ] = 4;
		totalLength[ 2 ] = 1;
		totalLength[ 3 ] = 1;
		totalLength[ 4 ] = 1;
		System.arraycopy( baseModel.getDataLengh() , 0 , totalLength , pre , dataLength );
		return totalLength;
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
