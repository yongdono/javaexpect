package com.nemo.javaexpect.shell.driver;

import java.io.InputStream;
import java.io.OutputStream;

import com.nemo.javaexpect.shell.DefaultCommandResult;
import com.nemo.javaexpect.shell.exception.CommandTimeoutException;
import com.nemo.javaexpect.shell.exception.ConnectionException;

/**
 * A remote connection, it contains an InputStream and OutputStream
 * @author yunhua
 *
 */
public interface Connection {
	public void close();
	public OutputStream getOutputStream();
	public InputStream getInputStream();	
	boolean isActive();
}
