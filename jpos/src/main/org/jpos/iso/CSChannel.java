package uy.com.cs.jpos.iso;

import java.io.*;
import java.util.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ISOChannel implementation - CS standard Channel<br>
 * We at <a href="http://www.cs.com.uy">CS</a>, have used
 * the so called ISOChannels for a long time. This class
 * talks with our legacy C++ based systems.<br>
 *
 * @author apr@cs.com.uy
 * @version $Id$
 * @see ISOMsg
 * @see ISOException
 * @see ISOChannel
 */
public class CSChannel extends ISOChannel {
	/**
	 * @param host	server TCP Address
	 * @param port  server port number
	 * @param p     an ISOPackager
	 * @see ISOPackager
	 */
	public CSChannel (String host, int port, ISOPackager p) {
		super(host, port, p);
	}
	/**
	 * @param len the packed Message len
	 * @exception IOException
	 */
	protected void sendMessageLength(int len) throws IOException {
		serverOut.write (len >> 24);
		serverOut.write (len >> 16);
		serverOut.write (len >> 8);
		serverOut.write (len);
	}
	/**
	 * @return the Message len
	 * @exception IOException, ISOException
	 */
	protected int getMessageLength() throws IOException, ISOException {
		byte[] b = new byte[4];
		if (serverIn.read(b,0,4) != 4)
			throw new ISOException("error reading message length");
		return (int) (b[0] << 24) | (b[1] << 16) | (b[2] << 8) | b[3];
	}
}
