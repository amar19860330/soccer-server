package com.amar.soccer.code.util;

import java.io.UnsupportedEncodingException;

import com.amar.soccer.code.constant.Constant;
import com.amar.soccer.code.exception.DataBeyondLimitException;

public class DataTrans
{
	/**
	 * 等处理的最大int数，再大就受不了啦
	 */
	public static int Integer_Max = Integer.MAX_VALUE - 1;

	/**
	 * @param first
	 * @param second
	 * @return 返回 first 和 second 连接起来的数组
	 */
	public static byte [] connectAB( byte [] first , byte [] second )
	{
		byte [] newArray = new byte [ first.length + second.length ];

		System.arraycopy( first , 0 , newArray , 0 , first.length );
		System.arraycopy( second , 0 , newArray , first.length , second.length );

		return newArray;
	}

	
	public static byte [] toBytes4( int originData )
	{
		byte [] result = null;
		try
		{
			if ( originData > Integer_Max )
			{
				throw new DataBeyondLimitException();
			}
			else
			{
				result = intToByte4( originData );
			}
		}
		catch ( DataBeyondLimitException e )
		{
			e.printStackTrace();
		}
		return result;
	}

	public static int bytes4ToInt( byte [] bytes )
	{
		int addr = bytes[ 0 ] & 0xFF;

		addr |= ( ( bytes[ 1 ] << 8 ) & 0xFF00 );

		addr |= ( ( bytes[ 2 ] << 16 ) & 0xFF0000 );

		addr |= ( ( bytes[ 3 ] << 24 ) & 0xFF000000 );

		return addr;
	}

	public static byte [] intToByte4( int i )
	{
		byte [] abyte0 = new byte [ 4 ];

		abyte0[ 0 ] = ( byte ) ( 0xff & i );

		abyte0[ 1 ] = ( byte ) ( ( 0xff00 & i ) >> 8 );

		abyte0[ 2 ] = ( byte ) ( ( 0xff0000 & i ) >> 16 );

		abyte0[ 3 ] = ( byte ) ( ( 0xff000000 & i ) >> 24 );

		return abyte0;
	}

	public static int bytesToInt1( byte [] bytes )
	{
		int addr = bytes[ 0 ] & 0xFF;

		return addr;
	}

	public static byte [] intToByte1( int i )
	{
		byte [] abyte0 = new byte [ 4 ];

		abyte0[ 0 ] = ( byte ) ( 0xff & i );

		return abyte0;
	}
}
