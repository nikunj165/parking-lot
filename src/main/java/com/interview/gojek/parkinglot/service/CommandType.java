/**
 * 
 */

package com.interview.gojek.parkinglot.service;

/**
 * @author nikunj-jain
 */
public enum CommandType {

  CREATE("create_parking_lot"),
  PARK("park"),
  UNPARK("leave"),
  GET_SLOTS_BY_COLOR("slot_numbers_for_cars_with_colour"),
  GET_SLOT_BY_REGNUM("slot_number_for_registration_number"),
  GET_REGNUMS_BY_COLOR("registration_numbers_for_cars_with_colour"),
  STATUS("status");
  private String desc;

  CommandType(String desc) {
    this.setDescription(desc);
  }

  public String getDescription() {
    return desc;
  }

  public void setDescription(String desc) {
    this.desc = desc;
  }
}
