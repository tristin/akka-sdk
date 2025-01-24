/*
 * Copyright (C) 2024 Lightbend Inc. <https://www.lightbend.com>
 */
package customer;

import akka.javasdk.ServiceSetup;
import akka.javasdk.annotations.Setup;
import customer.application.CustomerSummaryByName;
import customer.application.CustomersByCity;
import customer.application.CustomersByEmail;
import customer.application.CustomersResponseByName;

import java.util.Set;

@Setup
public class CustomerSetup implements ServiceSetup {
  @Override
  public Set<Class<?>> disabledComponents() {
    return Set.of(CustomersByCity.class, CustomersByEmail.class, CustomerSummaryByName.class, CustomersResponseByName.class);
  }
}
