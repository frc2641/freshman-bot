// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.team2641.freshmanbot.commands;

import edu.wpi.first.networktables.BooleanPublisher;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.Command;

public class Shift extends Command {
  BooleanPublisher shiftPub;

  /** Creates a new Shift. */
  public Shift() {
    NetworkTable table = NetworkTableInstance.getDefault().getTable("state");

    shiftPub = table.getBooleanTopic("shift").publish();
    shiftPub.set(false);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {             
    shiftPub.set(true);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shiftPub.set(false);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
