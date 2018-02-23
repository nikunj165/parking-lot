/**
 * 
 */

package com.interview.gojek.parkinglot.service;

import com.interview.gojek.parkinglot.command.Command;
import com.interview.gojek.parkinglot.command.InvalidCommand;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author nikunj-jain This is a service to read commands from the file or
 *         System.out.
 */
public class CommandParser {
  private BufferedReader bufferedReader;

  public CommandParser(String args) {
    String fileName;
    FileInputStream fis;

    if (args != null && args.length() > 0) {
      fileName = args;
      try {
        fis = new FileInputStream(fileName);
      } catch (FileNotFoundException e) {
        System.out.println("Input File Not Found Exception" + e);
        return;
      }
      bufferedReader = new BufferedReader(new InputStreamReader(fis));
    } else {
      bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }
  }

  public Command parseCommand(Command[] availableCommands) {
    try {
      String string = bufferedReader.readLine();
      if (string == null || string.isEmpty())
        return null;
      String command[] = string.split(" ");
      for (Command c : availableCommands) {
        if (c.getDescription().equals(command[0])) {
          return c.makeCommand(command);
        }
      }
      return new InvalidCommand();
    } catch (IOException e) {
      System.out.println("Could not read the command " + e);
      return null;
    }
  }
}
