/*
 * Copyright (C) 2021-2024 Lightbend Inc. <https://www.lightbend.com>
 */

package akka.javasdk.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Set profiles to a component. This can be used to enable or disable components based on the configuration.
 * A profile expression allows to set more than one profile, for example "prod & gcp".
 *
 * Configuration which profiles are active can be set in the <code>application.conf</code> configuration file e.g.
 * <pre>{@code
 * akka.javasdk.profiles.active = prod,gcp
 * }
 * </pre>
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Profile {
  /**
   * The set of profiles for which the annotated component should be enabled.
   * The component will be enabled if all the profiles are active.
   */
  String[] value();
}
