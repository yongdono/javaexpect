package com.nemo.javaexpect.shell.core;

/**
 * Define a remote target. it includes the host IP or name, login name and login password...
 * @author canhual
 *
 */
public class DefaultTarget implements Target {
	public DefaultTarget() {
		super();
	}
	public DefaultTarget(String host) {
		this.host = host;
	}
	private String shellID;
	
	/** IP or host name of the target */
	private String host;
	
	/** the target listening port */
	private int port = INVALID_PORT;
	
	/** login information */
	private String loginName;
	private String loginPassword = "";
	private String loginPrompt = ".*(>|\\$)";
	
	/** Indicate if autologin the shell
	 * @see #isAutoLogin()
	 *  */
	private boolean autoLogin = false;

	/* (non-Javadoc)
	 * @see com.nemo.service.shell.core.Target#isAutoLogin()
	 */
	@Override
	public boolean isAutoLogin() {
		return autoLogin;
	}
	
	/** Indicate if we need send a CR before auto login */
	private boolean initialCR = false;
	
	/**  
	 * su: run a shell with substitute user and group IDs
	 * su information 
	 * */
	private String suName;
	private String suPassword = "";
	private String suPrompt = ".*(>|\\$)";
	
	private boolean autoSU = false;; 
	
	/** the timeout setting for command execution. in seconds */
	private int commandTimeout = DEFAULT_COMMAND_TIMEOUT;

	private boolean suWithLoginShell = false;

/* (non-Javadoc)
 * @see com.nemo.service.shell.core.Target#isSUWithLoginShell()
 */
	@Override
	public boolean isSUWithLoginShell () {
		return suWithLoginShell;
	}
	
	/* (non-Javadoc)
	 * @see com.nemo.service.shell.core.Target#setSUWithLoginShell(boolean)
	 */	
	@Override
	public Target setSUWithLoginShell(boolean suWithLoginShell) {
		this.suWithLoginShell =suWithLoginShell;
		return this;
	}
	
	/* (non-Javadoc)
	 * @see com.nemo.service.shell.core.Target#getHost()
	 */
	@Override
	public String getHost() {
		return host;
	}

	/* (non-Javadoc)
	 * @see com.nemo.service.shell.core.Target#setHost(java.lang.String)
	 */
	@Override
	public Target setHost(String host) {
		this.host = host;
		return this;
	}

	/* (non-Javadoc)
	 * @see com.nemo.service.shell.core.Target#getPort()
	 */
	@Override
	public int getPort() {
		return port;
	}

	/* (non-Javadoc)
	 * @see com.nemo.service.shell.core.Target#setPort(int)
	 */
	@Override
	public Target setPort(int port) {
		this.port = port;
		return this;
	}

	/* (non-Javadoc)
	 * @see com.nemo.service.shell.core.Target#getLoginName()
	 */
	@Override
	public String getLoginName() {
		return loginName;
	}

	/* (non-Javadoc)
	 * @see com.nemo.service.shell.core.Target#setLoginName(java.lang.String)
	 */
	@Override
	public Target setLoginName(String loginName) {
		this.loginName = loginName;
		return this;
	}

	/* (non-Javadoc)
	 * @see com.nemo.service.shell.core.Target#getLoginPassword()
	 */
	@Override
	public String getLoginPassword() {
		return loginPassword;
	}

	/* (non-Javadoc)
	 * @see com.nemo.service.shell.core.Target#setLoginPassword(java.lang.String)
	 */
	@Override
	public Target setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
		return this;
	}

	/* (non-Javadoc)
	 * @see com.nemo.service.shell.core.Target#getLoginPrompt()
	 */
	@Override
	public String getLoginPrompt() {
		return loginPrompt;
	}

	/* (non-Javadoc)
	 * @see com.nemo.service.shell.core.Target#setLoginPrompt(java.lang.String)
	 */ 
	@Override
	public Target setLoginPrompt(String loginPrompt) {
		this.loginPrompt = loginPrompt;
		return this;
	}

	/* (non-Javadoc)
	 * @see com.nemo.service.shell.core.Target#getAutoLogin()
	 */
	@Override
	public Boolean getAutoLogin() {
		return autoLogin;
	}

	/* (non-Javadoc)
	 * @see com.nemo.service.shell.core.Target#setAutoLogin(java.lang.Boolean)
	 */
	@Override
	public Target setAutoLogin(Boolean autoLogin) {
		this.autoLogin = autoLogin;
		return this;
	}

	/* (non-Javadoc)
	 * @see com.nemo.service.shell.core.Target#isInitialCR()
	 */
	@Override
	public boolean isInitialCR() {
		return initialCR;
	}

	/* (non-Javadoc)
	 * @see com.nemo.service.shell.core.Target#setInitialCR(boolean)
	 */ 		
	@Override
	public Target setInitialCR(boolean initialCR) {
		this.initialCR = initialCR;
		return this;
	}

	/* (non-Javadoc)
	 * @see com.nemo.service.shell.core.Target#getSuName()
	 */
	@Override
	public String getSuName() {
		return suName;
	}

	/* (non-Javadoc)
	 * @see com.nemo.service.shell.core.Target#setSuName(java.lang.String)
	 */
	@Override
	public Target setSuName(String suName) {
		this.suName = suName;
		return this;
	}

	/* (non-Javadoc)
	 * @see com.nemo.service.shell.core.Target#getSuPassword()
	 */
	@Override
	public String getSuPassword() {
		return suPassword;
	}

	/* (non-Javadoc)
	 * @see com.nemo.service.shell.core.Target#setSuPassword(java.lang.String)
	 */
	@Override
	public Target setSuPassword(String suPassword) {
		this.suPassword = suPassword;
		return this;
	}

	/* (non-Javadoc)
	 * @see com.nemo.service.shell.core.Target#getSuPrompt()
	 */
	@Override
	public String getSuPrompt() {
		return suPrompt;
	}

	/* (non-Javadoc)
	 * @see com.nemo.service.shell.core.Target#setSuPrompt(java.lang.String)
	 */ 	
	@Override
	public Target setSuPrompt(String suPrompt) {
		this.suPrompt = suPrompt;
		return this;
	}

	/* (non-Javadoc)
	 * @see com.nemo.service.shell.core.Target#isAutoSU()
	 */
	@Override
	public boolean isAutoSU() {
		return autoSU;
	}

	/* (non-Javadoc)
	 * @see com.nemo.service.shell.core.Target#setAutoSU(boolean)
	 */
	@Override
	public Target setAutoSU(boolean autoSU) {
		this.autoSU = autoSU;
		return this;
	}

	/* (non-Javadoc)
	 * @see com.nemo.service.shell.core.Target#getCommandTimeout()
	 */
	@Override
	public int getCommandTimeout() {
		return commandTimeout;
	}

	/* (non-Javadoc)
	 * @see com.nemo.service.shell.core.Target#setCommandTimeout(int)
	 */
	@Override
	public Target setCommandTimeout(int commandTimeout) {
		this.commandTimeout = commandTimeout;
		return this;
	}
	
	/* (non-Javadoc)
	 * @see com.nemo.service.shell.core.Target#isInvalidPort()
	 */
	@Override
	public boolean isInvalidPort() {
		return (port==INVALID_PORT);
	}
	
	/** 
	 * the shell will first autologin with this loginName and loginPassword.
	 * then waiting for the shellPrompt
	 * @param loginName 
	 * @param loginPassword 
	 * @param shellPrompt it's a match pattern.
	* pattern can refer to regex in {@link java.lang.String#matches(String regex)}
	* @return Target itself
	*/ 
	Target setAutoLogin(String loginName, String loginPassword, String shellPrompt) {
		this.setAutoLogin(true);
		this.setLoginName(loginName);
		this.setLoginPassword(loginPassword);
		this.setLoginPrompt(shellPrompt);
		return this;
	}
	
	/** 
	 * the shell will execute su with this suName and suPassword.
	 * then waiting for the shellPrompt
	 * @param loginName 
	 * @param loginPassword 
	 * @param shellPrompt it's a match pattern.
	* pattern can refer to regex in {@link java.lang.String#matches(String regex)}
	* @return Target itself
	*/ 	
	Target setAutoSU(String suName, String suPassword, String shellPrompt) {
		this.setSuName(suName);
		this.setSuPassword(suPassword);
		this.setSuPrompt(shellPrompt);
		this.setAutoSU(true);
		return this;
	}
	@Override
	public Target setShellID(String id) {
		this.shellID = id;
		return this;
	}
	@Override
	public String getShellID() {
		return shellID;
	}
}
