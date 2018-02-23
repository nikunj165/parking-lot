/**
 * 
 */

package com.interview.gojek.parkinglot.exceptions;

/**
 * @author nikunj-jain
 */
public class SlotEmptyException extends Exception {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  String message;

  public SlotEmptyException(String message) {
    this.message = message;

  }
}
