package jenkins.model;

import org.junit.*;
import static org.junit.Assert.*;

public class IdFromFilenameTest {
	@Test public void regularCopy() throws Exception {
	//comment
	IdStrategy.CaseSensitive nestedObj = new IdStrategy.CaseSensitive();

	String filename = "[a-z0-9_. -]+";
	String output = nestedObj.idFromFilename(filename);
	assertEquals(filename, output);
	}

	@Test public void regularOurs() throws Exception {
	IdStrategy.CaseSensitive nestedObj = new IdStrategy.CaseSensitive();

	String filename = "acb123_.- @";
	String output = nestedObj.idFromFilename(filename);
	assertEquals(filename, output);
	}

	@Test public void squigly() throws Exception {
	IdStrategy.CaseSensitive nestedObj = new IdStrategy.CaseSensitive();

	String filename = "~a";
	String output = nestedObj.idFromFilename(filename);
	String expected = "A";
	assertEquals(expected, output);

	String filename2 = "a~";
	String output2 = nestedObj.idFromFilename(filename2);
	String expected2 = "a";
	assertEquals(expected2, output2);
	}

	@Test public void dollarsign() throws Exception {
	IdStrategy.CaseSensitive nestedObj = new IdStrategy.CaseSensitive();

	String filename = "$0041";
	String output = nestedObj.idFromFilename(filename);
	String expected = "A";
	assertEquals(expected, output);


	String filename2 = "abc$";
	String output2 = nestedObj.idFromFilename(filename2);
	String expected2 = "abc";
	assertEquals(expected2, output2);
	}

}



