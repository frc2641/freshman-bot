package frc.team2641.freshmanbot;

// import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.team2641.freshmanbot.commands.DrivingCommand;
import frc.team2641.freshmanbot.subsystems.*;

public class RobotContainer {
  public final DrivingSubsystem drivingSubsystem = new DrivingSubsystem();

  public XboxController driver = new XboxController(Constants.Controllers.driver);

  public boolean driverShift = false;

  public RobotContainer() {
    configureButtonBindings();

    drivingSubsystem.setDefaultCommand(new DrivingCommand(drivingSubsystem));
  }

  private void configureButtonBindings() {
  }
}