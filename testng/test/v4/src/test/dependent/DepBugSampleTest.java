package test.dependent;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Configuration;
import org.testng.annotations.Test;

@Test
public class DepBugSampleTest {
  private static List<String> m_log = new ArrayList<String>();
  
  private static void log(String s) {
//    ppp(s);
    m_log.add(s);
  }
  
  private static void ppp(String s) {
    System.out.println("[DepBugSampleTest] " + s);
  }
  
  public static List<String> getLog() {
    return m_log;
  }

  @Configuration(beforeTestClass = true)
  public void setup() throws Exception {
    log("setup");
  }

  @Configuration(afterTestClass = true)
  public void destroy() throws Exception {
    log("destroy");
  }

  @Test(dependsOnMethods = "send")
  public void get() throws Exception {
    log("get");
  }

  public void send() throws Exception {
    log("send");
  }

  public void list() throws Exception {
    log("list");
  }
}