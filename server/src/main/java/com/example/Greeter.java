package com.example;

/**
 * This is a class.
 */
public class Greeter {

  /**
   * This is a constructor.
   */
  public Greeter() {

  }

  /**
  * @param param pam
  * @return of the great white dope
  */
  public final String greet(final String someone) {
    return String.format("Hello, %s!", someone);
  }
}
