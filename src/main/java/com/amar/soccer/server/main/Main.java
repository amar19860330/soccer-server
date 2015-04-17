package com.amar.soccer.server.main;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import com.amar.soccer.server.main.code.ByteProtocolCodecFactory;

public class Main
{
	private static final int PORT = 6488;
	
	public static void main( String [] args ) throws IOException
	{
		IoAcceptor acceptor = new NioSocketAcceptor();
		acceptor.getFilterChain().addLast( "logger" , new LoggingFilter() );
		//acceptor.getFilterChain().addLast( "codec" , new ProtocolCodecFilter( new ByteProtocolCodecFactory() ) );
		acceptor.getFilterChain().addLast( "codec" , new ProtocolCodecFilter( new TextLineCodecFactory( Charset.forName( "UTF-8" ) ) ) );
		acceptor.setHandler( new ServerHandler() );
		acceptor.getSessionConfig().setReadBufferSize( 2048 );
		acceptor.getSessionConfig().setIdleTime( IdleStatus.BOTH_IDLE , 10 );
		acceptor.bind( new InetSocketAddress( PORT ) );
	}

}
