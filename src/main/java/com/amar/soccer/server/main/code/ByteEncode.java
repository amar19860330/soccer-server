package com.amar.soccer.server.main.code;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

public class ByteEncode implements ProtocolEncoder
{

	@Override
	public void encode( IoSession session , Object message , ProtocolEncoderOutput out ) throws Exception
	{
		String data = message.toString();
		byte [] orgData = data.getBytes();
		IoBuffer buf = IoBuffer.allocate( orgData.length );
		buf.put( orgData );
		buf.flip();
		out.write( buf );
		
		/*byte [] orgData = ( byte [] ) message;
		byte [] header = new byte [ 4 ];
		for( int i = 0 ; i < 4 ; i ++ )
		{
			header[ i ] = orgData[ i ];
		}
		int length = bytesToInt( header );

		IoBuffer buf = IoBuffer.allocate( length );
		buf.setAutoExpand( true );
		buf.putInt( orgData.length );
		buf.put( orgData );
		buf.flip();
		out.write( buf );*/

	}

	@Override
	public void dispose( IoSession session ) throws Exception
	{
		// TODO Auto-generated method stub

	}


	

}
