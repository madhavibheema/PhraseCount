/**
 * 
 */
package com.newrelic.phrase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class PhraseCountTest {

    private static final String RESOURCES_FOLDER = "src/test/resources/";

    private static final String EMPTY_FILE_TXT = RESOURCES_FOLDER + "empty_file.txt";
    public static final String MOBYDICK_TXT =  RESOURCES_FOLDER + "mobydick.txt";

    public static final String UTF_TXT =  RESOURCES_FOLDER + "utf.txt";



    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    private final PrintStream printStream = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @After
    public void restoreStreams() {
        System.setOut(printStream);
    }


	
	@Test
    public void testMainStdInProcess() throws IOException {
        String[] args = new String[0];
        final InputStream original = System.in;
        final FileInputStream fips = new FileInputStream(new File(UTF_TXT));
        System.setIn(fips);
        PhraseCount.main(args);
        System.setIn(original);
    }
	
	@Test
    public void testWithEmptyFile() throws IOException {
        String[] args = new String[] {EMPTY_FILE_TXT};
        PhraseCount.main(args);
    }

	
	@Test
    public void testHyphen() {
        String testString = "Blue's";
        String successString = "blue's";
        List<String> matches = PhraseCount.getMatchesAsList(testString);
        assertEquals(successString, String.join(" ", matches));
    }
	

}
