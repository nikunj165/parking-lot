
package com.interview.gojek.parkinglot.test;

import com.interview.gojek.parkinglot.App;
import com.interview.gojek.parkinglot.service.IParkingLotService;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.Arrays;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
  IParkingLotService parkingLotService;

  public void test1() throws Exception {
    App app = new App(new String[] { "input", "testOutput1" });
    app.start();
    app.getOut().flush();
    byte[] a = Files.readAllBytes(FileSystems.getDefault().getPath("output"));
    byte[] b = Files.readAllBytes(FileSystems.getDefault().getPath("testOutput1"));
    Assert.assertEquals(true, Arrays.equals(a, b));
  }

  public void test2() throws Exception {
    App app = new App(new String[] { "input2", "testOutput2" });
    app.start();
    app.getOut().flush();
    byte[] a = Files.readAllBytes(FileSystems.getDefault().getPath("testOutput2"));
    byte[] b = Files.readAllBytes(FileSystems.getDefault().getPath("output2"));
    Assert.assertEquals(true, Arrays.equals(a, b));
  }

  /**
   * Create the test case
   *
   * @param testName
   *          name of the test case
   */
  public AppTest(String testName) {
    super(testName);
  }

  /**
   * @return the suite of tests being tested
   */
  public static Test suite() {
    return new TestSuite(AppTest.class);
  }

}
