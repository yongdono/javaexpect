# Purpose #
  * Integrate with junit or other automation framework
  * Replace expect for batch or other telnet/ssh interactive jobs

# Why this project created? #
In the telecommunication or other IT domain, we need control tens of hundred of machines in a same way. We can write expect (TCL) script to finish it. This project provides similar functions but it provides more:
  1. it’s written in java and it’s easy to integrate with JUnit or other framework to do automation test.
  1. the log with expect is not readable, it includes many xterm control sequences
  1. We can customize the xterm output by ourself, it would provide more debug information like which line of java code introduced which kind of result
  1. provide easy way to assert the command result.

Restriction:
**Only support ssh and telnet**

# do similar work like expect/tcl #
---
TCL expect version:
```
#!/usr/bin/expect 
spawn telnet localhost
expect “login:”
send  “name\r”
expect "password: " 
send "vmkid\r" 
expect "~# " 
send “ls\r”
expect "~# " 
send “pwd\r”
expect "~# " 
```

---
javaexpect version:
```
TelnetDriver driver= new TelnetDriver("localhost");
driver.setAutoLogin("name", "password", "~#");
Shell shell = driver.open();
shell.execute("ls");
shell.execute("pwd");
shell.close();
```

# More Easier to do the telnet/ssh shell jobs: #
We can use **execute** to replace **send/expect** pair.

  * telnet
```
package examples;
import com.nemo.javaexpect.shell.Shell;
import com.nemo.javaexpect.shell.driver.TelnetDriver;

public class TelnetDemo {

	public static void main(String[] args) {
	foreach 
		TelnetDriver driver= new TelnetDriver("125.252.181.222");
		driver.setAutoLogin("guest", "guest", "guest>");
		Shell shell = driver.open();
		shell.execute("ls");
		shell.execute("pwd");
		shell.close();
	}

}

```

  * Ssh demo:
```
driver = new SshDriver("125.252.181.79", "guest", "guest","guest>");
shell = driver.open();
shell.execute("ls");
shell.send("ls");
hell.expect("guest>" );
System.out.println(shell.execute("ls").getCommandResult());	
```

# More readable: filter xterm or VT100 control sequences #
We default would filter the control sequences automatically. It would be more readable than expect. We can skip the VT100 filter function by setSkipVT100Filter
```
SshDriver driver = new SshDriver("125.252.181.79" , "guest", "guest","guest>");
driver.setSkipVT100Filter(true); // disable filter here. we'll get the raw data
Shell shell = driver.open();
shell.execute("ls");
shell.send("ls");
shell.expect("guest>" );
System.out.println(shell.execute("ls").getCommandResult());
```


# Integrated with JUnit framework. #
It's easy to write JUnit test cases. You don't need to write assertion but just call **requireText**

```
import static org.junit.Assert.*;
import org.junit.Test;
import com.nemo.javaexpect.shell.CommandResult;
import com.nemo.javaexpect.shell.Shell;
import com.nemo.javaexpect.shell.driver.TelnetDriver;

public class testTest {

	@Test
	public void test() {
		TelnetDriver driver= new TelnetDriver("rainmaker.wunderground.com");
		Shell shell = driver.open();
		shell.expect("Press Return to continue").
			requireText("comments: jmasters@wunderground.com").
			requireText("National Weather Service");
		shell.send("\n");
		CommandResult result = shell.expect("enter 3 letter forecast city code--");
		result.getCommandResult().contains("Press Return for menu");
	}

}

```

# Auto su to other account without user's interaction #

```
TelnetDriver driver= new TelnetDriver("125.252.181.222");
driver.setAutoLogin("guest", "guest", "guest>");
driver.setAutoSU("root", "root", "\\$");
Shell shell = driver.open();
shell.execute("ls");
```
# More readable logs than expect demo: #
```
telnet rainmaker.wunderground.com 23
------------------------------------------------------------------------------

*               Welcome to THE WEATHER UNDERGROUND telnet service!            *
…
*           comments: jmasters@wunderground.com                              *

------------------------------------------------------------------------------


Press Return to continue:
Press Return for menu
or enter 3 letter forecast city code--

```

# Create a xml version of the shell output in your own way #
```
		TelnetDriver driver= new TelnetDriver("rainmaker.wunderground.com");
		DefaultShellDriver.setShellLogger(new HtmlShellLogger());
		Shell shell = driver.open();
		
		shell.expect("Press Return to continue");
		shell.send("\n");
		shell.expect("enter 3 letter forecast city code--", 10 );
		shell.send("\n");
```

```xml


<shell><time>2013-01-19 04:54:26

Unknown end tag for &lt;/time&gt;

<lineInCase>examples.TelnetHtmlLoggerDemo.main(TelnetHtmlLoggerDemo.java:17)

Unknown end tag for &lt;/lineInCase&gt;

<shellID>rainmaker.wunderground.com:23@14806696

Unknown end tag for &lt;/shellID&gt;

<shellCommand>telnet rainmaker.wunderground.com 23

Unknown end tag for &lt;/shellCommand&gt;

<shellOutput>telnet rainmaker.wunderground.com 23


Unknown end tag for &lt;/shellOutput&gt;



Unknown end tag for &lt;/shell&gt;


<shell><time>2013-01-19 04:54:26

Unknown end tag for &lt;/time&gt;

<lineInCase>examples.TelnetHtmlLoggerDemo.main(TelnetHtmlLoggerDemo.java:19)

Unknown end tag for &lt;/lineInCase&gt;

<shellID>rainmaker.wunderground.com:23@14806696

Unknown end tag for &lt;/shellID&gt;

<shellCommand>expect("Press Return to continue")

Unknown end tag for &lt;/shellCommand&gt;

<shellOutput>------------------------------------------------------------------------------

*               Welcome to THE WEATHER UNDERGROUND telnet service!            *

---------------------------------------------------------------------------…
Press Return to continue

Unknown end tag for &lt;/shellOutput&gt;



Unknown end tag for &lt;/shell&gt;


<shell><time>2013-01-19 04:54:26

Unknown end tag for &lt;/time&gt;

<lineInCase>examples.TelnetHtmlLoggerDemo.main(TelnetHtmlLoggerDemo.java:20)

Unknown end tag for &lt;/lineInCase&gt;

<shellID>rainmaker.wunderground.com:23@14806696

Unknown end tag for &lt;/shellID&gt;

<shellCommand>send("
")

Unknown end tag for &lt;/shellCommand&gt;

<shellOutput>

Unknown end tag for &lt;/shellOutput&gt;



Unknown end tag for &lt;/shell&gt;


<shell><time>2013-01-19 04:54:26

Unknown end tag for &lt;/time&gt;

<lineInCase>examples.TelnetHtmlLoggerDemo.main(TelnetHtmlLoggerDemo.java:21)

Unknown end tag for &lt;/lineInCase&gt;

<shellID>rainmaker.wunderground.com:23@14806696

Unknown end tag for &lt;/shellID&gt;

<shellCommand>expect("enter 3 letter forecast city code--",10)

Unknown end tag for &lt;/shellCommand&gt;

<shellOutput>:
Press Return for menu
or enter 3 letter forecast city code--

Unknown end tag for &lt;/shellOutput&gt;



Unknown end tag for &lt;/shell&gt;



```

# provided more debug information #
In the above example, we can see we executed
```
expect("enter 3 letter forecast city code--",10)
```
and the result is
```
:
Press Return for menu
or enter 3 letter forecast city code--
```

Which is called from TelnetHtmlLoggerDemo.java:21
```
examples.TelnetHtmlLoggerDemo.main(TelnetHtmlLoggerDemo.java:21)
```

# Examples #
[examples](http://code.google.com/p/javaexpect/source/browse/#svn%2Ftrunk%2Fsrc%2Ftest%2Fjava%2Fexamples)

# How to use #
Download smart-0.1-SNAPSHOT-jar-with-dependencies.jar from download page and add it into classpath

# How to compile #
  1. download the source code with svn
```
svn checkout http://javaexpect.googlecode.com/svn/trunk/ javaexpect-read-only
```
  1. mvn compile

# Please find more intresting functionanity from source code #