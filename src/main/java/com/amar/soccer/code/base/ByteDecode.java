package com.amar.soccer.code.base;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

import com.amar.soccer.server.util.DataTool;


public class ByteDecode extends CumulativeProtocolDecoder
{

	@Override
	protected boolean doDecode( IoSession session , IoBuffer in , ProtocolDecoderOutput out ) throws Exception
	{
		boolean result = false;
		if ( in.remaining() >= 0 )
		{
			byte [] length = new byte [ 4 ];
			in.get( length );
			int dataLength = DataTool.bytesToInt( length ) - 4;
			byte [] data = new byte [ dataLength ];
			in.get( data );

			String s = new String( data );

			out.write( s );

			result = true;
		}
		return result;
	}

}
