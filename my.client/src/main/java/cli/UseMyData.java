package cli;

import prov.MyServiceIf;

import java.lang.reflect.Field;
import java.util.ServiceLoader;

public class UseMyData {
  public static void main(String[] args) throws Throwable {
    System.out.println("this is UseMyData, message from MyData is"
        + prov.MyData.message);

    // nope, obviously
//    System.out.println("Secret message? " + prov.MyData.secret);

    Field secretField = prov.MyData.class.getDeclaredField("secret");
    secretField.setAccessible(true);
    // null would be the "this" object
    String secretMessage = (String)secretField.get(null);
    System.out.println("secret message: " + secretMessage);

    ServiceLoader<MyServiceIf> loader = ServiceLoader.load(MyServiceIf.class);
    for (MyServiceIf serv : loader) {
      System.out.println("found a service: " + serv.getClass().getName());
      System.out.println("message from service is " + serv.getMessage());
    }
  }
}
