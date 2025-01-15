// Copyright (c) 2024 FRC Team 2641
// Use of this source code is governed by the MIT license

package frc.team2641.freshmanbot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.team2641.freshmanbot.Robot;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Climber extends SubsystemBase {
  private static Climber instance;

  public static Climber getInstance() {
    if (instance == null)
      instance = new Climber();
    return instance;
  }

  private DoubleSolenoid climber = Robot.getPH().makeDoubleSolenoid(7, 6);

  private Climber() {
    close();
  }

  public void depressurize() {
    climber.set(DoubleSolenoid.Value.kOff);
  }

  public void close() {
    climber.set(DoubleSolenoid.Value.kReverse);
  }

  public void open() {
    climber.set(DoubleSolenoid.Value.kForward);
  }

  public void toggle() {
    if (get().equals(DoubleSolenoid.Value.kReverse))
      open();
    else
      close();
  }

  public DoubleSolenoid.Value get() {
    return climber.get();
  }

  @Override
  public void periodic() {
  }
}