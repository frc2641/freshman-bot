package frc.team2641.freshmanbot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.team2641.freshmanbot.Constants;

public class Drivetrain extends SubsystemBase {
  private static Drivetrain instance = null;

  public static Drivetrain getInstance() {
    if (instance == null)
      instance = new Drivetrain();
    return instance;
  }

  public WPI_TalonSRX leftMotor1 = new WPI_TalonSRX(Constants.Motors.leftMotor1);
  public WPI_TalonSRX leftMotor2 = new WPI_TalonSRX(Constants.Motors.leftMotor2);

  public WPI_TalonSRX rightMotor1 = new WPI_TalonSRX(Constants.Motors.rightMotor1);
  public WPI_TalonSRX rightMotor2 = new WPI_TalonSRX(Constants.Motors.rightMotor2);

  public DifferentialDrive differentialDrive = new DifferentialDrive(leftMotor1, rightMotor1);

  public Drivetrain() {
    leftMotor1.clearStickyFaults();
    leftMotor2.clearStickyFaults();
    rightMotor1.clearStickyFaults();
    rightMotor2.clearStickyFaults();

    leftMotor2.follow(leftMotor1);
    rightMotor2.follow(rightMotor1);

    configBrakes(true);
    configRamps(Constants.MotorSpeeds.driveRampSpeed);
  }

  public void aDrive(double rotation, double speed) {
    differentialDrive.arcadeDrive(rotation, -speed * 1, true);
  }

  public void tDrive(double left, double right) {
    differentialDrive.tankDrive(-left, -right, true);
  }

  public void halt() {
    configRamps(Constants.MotorSpeeds.driveRampSpeed);
    configBrakes(Constants.MotorSpeeds.brakes);
    leftMotor1.stopMotor();
    leftMotor2.stopMotor();
    rightMotor1.stopMotor();
    rightMotor2.stopMotor();
  }

  public void configBrakes(boolean brakesOn) {
    NeutralMode input;
    if (brakesOn)
      input = NeutralMode.Brake;
    else
      input = NeutralMode.Coast;

    leftMotor1.setNeutralMode(input);
    leftMotor2.setNeutralMode(input);
    rightMotor1.setNeutralMode(input);
    rightMotor2.setNeutralMode(input);
  }

  public void configRamps(double driveRampSpeed) {
    leftMotor1.configOpenloopRamp(driveRampSpeed);
    leftMotor2.configOpenloopRamp(driveRampSpeed);
    rightMotor1.configOpenloopRamp(driveRampSpeed);
    rightMotor2.configOpenloopRamp(driveRampSpeed);
  }

  @Override
  public void periodic() {
  }
}