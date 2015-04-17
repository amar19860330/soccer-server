package com.amar.soccer.server.util;

import java.io.File;

public class DataTool
{
	public static int bytesToInt( byte [] bytes )
	{
		int addr = bytes[ 0 ] & 0xFF;

		addr |= ( ( bytes[ 1 ] << 8 ) & 0xFF00 );

		addr |= ( ( bytes[ 2 ] << 16 ) & 0xFF0000 );

		addr |= ( ( bytes[ 3 ] << 24 ) & 0xFF000000 );

		return addr;
	}

	public static byte [] intToByte( int i )
	{
		byte [] abyte0 = new byte [ 4 ];

		abyte0[ 0 ] = ( byte ) ( 0xff & i );

		abyte0[ 1 ] = ( byte ) ( ( 0xff00 & i ) >> 8 );

		abyte0[ 2 ] = ( byte ) ( ( 0xff0000 & i ) >> 16 );

		abyte0[ 3 ] = ( byte ) ( ( 0xff000000 & i ) >> 24 );

		return abyte0;

	}

	public static void deleteFile( File file )
	{
		if ( file.isDirectory() )
		{
			File [] files = file.listFiles();
			for( File _file : files )
			{
				deleteFile( _file );
			}
		}
		file.delete();
	}

	public static void checkFileDir( File file )
	{
		if ( ! file.exists() )
		{
			file.mkdirs();
		}
	}

	public static void main( String [] args )
	{
		byte [] s = intToByte( 1024 );

		int data = bytesToInt( s );

		for( int i = 0 ; i < s.length ; i ++ )
			System.out.print( s[ i ] + " " );
		System.out.println( "" + data );
	}
}
