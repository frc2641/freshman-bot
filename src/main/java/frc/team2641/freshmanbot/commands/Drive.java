package frc.team2641.freshmanbot.commands;

import edu.wpi.first.networktables.BooleanSubscriber;
import edu.wpi.first.wpilibj2.command.Command;
import frc.team2641.freshmanbot.Constants;
import frc.team2641.freshmanbot.Robot;
import frc.team2641.freshmanbot.subsystems.Drivetrain;

public class Drive extends Command {
  private Drivetrain drivetrain;
  private BooleanSubscriber driverShift;

  public Drive(BooleanSubscriber driverShift) {
    this.drivetrain = Drivetrain.getInstance();
    this.driverShift = driverShift;
    addRequirements(drivetrain);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    if (driverShift.getAsBoolean() == true) {
      double left = Robot.robotContainer.driverGamepad.getRawAxis(Constants.GamepadButtons.lyAxis);
      double right = Robot.robotContainer.driverGamepad.getRawAxis(Constants.GamepadButtons.ryAxis);
      drivetrain.tDrive(-left, right);
    } else {
      double rotation = Robot.robotContainer.driverGamepad.getRawAxis(Constants.GamepadButtons.lxAxis);
      double drive = Robot.robotContainer.driverGamepad.getRawAxis(Constants.GamepadButtons.ryAxis);
      drivetrain.aDrive(rotation, drive);
    }
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}