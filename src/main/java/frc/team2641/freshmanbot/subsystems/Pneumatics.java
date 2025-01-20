// Copyright (c) 2024 FRC Team 2641
// Use of this source code is governed by the MIT license

package frc.team2641.freshmanbot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.team2641.freshmanbot.Robot;

public class Pneumatics extends SubsystemBase {
  private static Pneumatics instance = null;

  public static Pneumatics getInstance() {
    if (instance == null)
      instance = new Pneumatics();
    return instance;
  }

  private Compressor compressor = Robot.getPH().makeCompressor();

  private Pneumatics() {
    disable();
  }

  public void enable() {
    compressor.enableDigital();
  }

  public void disable() {
    compressor.disable();
  }

  public boolean get() {
    return compressor.isEnabled();
  }

  @Override
  public void periodic() {
  }
}