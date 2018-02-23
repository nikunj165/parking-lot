/**
 * 
 */

package com.interview.gojek.parkinglot.exceptions;

/**
 * @author nikunj-jain
 */
public class SlotNotFoundException extends Exception {

  /**
   * 
   */
  private static final long serialVersionUID = -220142661334217836L;
  String message;

  public SlotNotFoundException(String message) {
    this.message = message;
  }

}
