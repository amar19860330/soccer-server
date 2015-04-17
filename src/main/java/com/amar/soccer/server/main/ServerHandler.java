package com.amar.soccer.server.main;

import java.util.Date;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

public class ServerHandler extends IoHandlerAdapter
{
	public void exceptionCaught( IoSession session , Throwable cause ) throws Exception
	{
		cause.printStackTrace();
	}

	public void messageReceived( IoSession session , Object message ) throws Exception
	{
		String strMsg = message.toString();

		long id = session.getId();
		Date createDate = new Date( session.getCreationTime() );
		System.out.println( "id:" + id + ",createDate:" + createDate.toString() + "," + "receice:" + strMsg );

		if ( strMsg.trim().equalsIgnoreCase( "quit" ) )
		{
			session.close( true );
		}
		else
		{
			Date date = new Date();
			session.write( "id:" + id + ",createDate:" + createDate.toString() + "," + date.toString() +"\n");
		}
	}

	public void sessionIdle( IoSession session , IdleStatus status ) throws Exception
	{
		System.out.println( "IDLE " + session.getIdleCount( status ) );
	}

	@Override
	public void sessionCreated( IoSession session ) throws Exception
	{
		super.sessionCreated( session );
	}

	@Override
	public void sessionOpened( IoSession session ) throws Exception
	{
		super.sessionOpened( session );
	}

	@Override
	public void messageSent( IoSession session , Object message ) throws Exception
	{
		System.out.println( message.toString() );
		super.messageSent( session , message );
	}

}
