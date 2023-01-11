package frc.team2641.freshmanbot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.team2641.freshmanbot.commands.ClawCommand;
import frc.team2641.freshmanbot.commands.DrivingCommand;
import frc.team2641.freshmanbot.commands.ShoulderCommand;
import frc.team2641.freshmanbot.subsystems.*;

public class RobotContainer {
  public final DrivingSubsystem drivingSubsystem = new DrivingSubsystem();
  public final ClawSubsystem clawSubsystem = new ClawSubsystem();
  public final ShoulderSubsystem shoulderSubsystem = new ShoulderSubsystem();

  public XboxController driver = new XboxController(Constants.Controllers.driver);

  public boolean driverShift = false;

  public JoystickButton clampButton = new JoystickButton(driver, Constants.GamepadButtons.aButton);
  public JoystickButton shoulderButton = new JoystickButton(driver, Constants.GamepadButtons.bButton);

  public RobotContainer() {
    configureButtonBindings();

    drivingSubsystem.setDefaultCommand(new DrivingCommand(drivingSubsystem));
  }

  private void configureButtonBindings() {
    clampButton.whenPressed(new ClawCommand(clawSubsystem, true));
    clampButton.whenReleased(new ClawCommand(clawSubsystem, false));
    shoulderButton.whileHeld(new ShoulderCommand(shoulderSubsystem));
  }
}