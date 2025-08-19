import prov.MyServiceIf;

/*open*/ module my.provider {
  exports prov;
//  exports prov to my.client, not.existing;
//  opens prov;
  opens prov to my.client;
  provides MyServiceIf with impls.MyServiceImplA;
}
