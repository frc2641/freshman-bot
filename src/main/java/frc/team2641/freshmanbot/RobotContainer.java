package frc.team2641.freshmanbot;

import edu.wpi.first.networktables.BooleanPublisher;
import edu.wpi.first.networktables.BooleanSubscriber;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.team2641.freshmanbot.commands.*;
import frc.team2641.freshmanbot.subsystems.*;

public class RobotContainer {
  public final Drivetrain drivetrain = Drivetrain.getInstance();

  public CommandXboxController driverGamepad = new CommandXboxController(Constants.Controllers.driver);

  BooleanPublisher shiftPub;
  BooleanSubscriber shiftSub;

  public RobotContainer() {
    configureButtonBindings();

    NetworkTable table = NetworkTableInstance.getDefault().getTable("state");

    shiftPub = table.getBooleanTopic("shift").publish();
    shiftPub.set(false);
    shiftSub = table.getBooleanTopic("shift").subscribe(false);

    drivetrain.setDefaultCommand(new Drive(shiftSub));
  }

  private void configureButtonBindings() {
    driverGamepad.leftBumper().whileTrue(new Shift());
  }
}