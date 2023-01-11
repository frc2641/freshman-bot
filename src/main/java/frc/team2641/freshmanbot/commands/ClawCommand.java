// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.team2641.freshmanbot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.team2641.freshmanbot.subsystems.ClawSubsystem;

public class ClawCommand extends CommandBase {

  private boolean direction;
  private ClawSubsystem clawSubsystem;

  public ClawCommand(ClawSubsystem clawSubsystem, boolean direction) {
    this.direction = direction;
    this.clawSubsystem = clawSubsystem;
    addRequirements(clawSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if (direction) {
      clawSubsystem.release();
    } else {
      clawSubsystem.clamp();
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
