/**
 * 
 */

package com.interview.gojek.parkinglot.model;

/**
 * @author nikunj-jain
 */
public abstract class Vehicle {

  private String registrationNumber;
  private String color;

  public Vehicle(String registrationNumber, String color) {
    this.registrationNumber = registrationNumber;
    this.color = color.toLowerCase();
  }

  public String getRegistrationNumber() {
    return registrationNumber;
  }

  public void setRegistrationNumber(String registrationNumber) {
    this.registrationNumber = registrationNumber;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color.toLowerCase();
  }

}
