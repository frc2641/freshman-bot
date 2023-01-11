// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.team2641.freshmanbot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.team2641.freshmanbot.Constants;

public class ShoulderSubsystem extends SubsystemBase {

  private WPI_TalonSRX shoulderMotor = new WPI_TalonSRX(Constants.Motors.shoulderMotor);

  /** Creates a new ShoulderSubsystem. */
  public ShoulderSubsystem() {
  }

  public void enable() {
    shoulderMotor.set(0.1);
  }

  public void disable() {
    shoulderMotor.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
