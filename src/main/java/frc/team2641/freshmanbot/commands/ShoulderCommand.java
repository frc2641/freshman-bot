// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.team2641.freshmanbot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.team2641.freshmanbot.subsystems.ShoulderSubsystem;

public class ShoulderCommand extends CommandBase {

  private ShoulderSubsystem shoulderSubsystem;

  public ShoulderCommand(ShoulderSubsystem shoulderSubsystem) {
    this.shoulderSubsystem = shoulderSubsystem;
    addRequirements(this.shoulderSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    shoulderSubsystem.enable();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shoulderSubsystem.disable();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
