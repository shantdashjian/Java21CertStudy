package impls;

import prov.MyServiceIf;

public class MyServiceImplA implements MyServiceIf {
  @Override
  public String getMessage() {
    return "message from a service";
  }
}
