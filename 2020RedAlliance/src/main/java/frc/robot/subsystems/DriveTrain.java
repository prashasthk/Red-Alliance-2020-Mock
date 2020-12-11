/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
// import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import frc.robot.OI;
import edu.wpi.first.wpilibj.PWMTalonSRX;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {

  private PWMTalonSRX left = new PWMTalonSRX(RobotMap.leftDrivePort);
  private PWMTalonSRX right = new PWMTalonSRX(RobotMap.rightDrivePort);
  // private PWMTalonSRX leftFollow = new PWMTalonSRX(2);
  // private PWMTalonSRX rightFollow = new PWMTalonSRX(3);
  private static DriveTrain drive;

  private double leftPower, rightPower;

  public DriveTrain() {
    left.setInverted(false);
    right.setInverted(true);
  }
  
  public static DriveTrain getInstance() {
    if(drive == null) {
      drive = new DriveTrain();
    }
    return drive;
  }

  public void tankDrive(double leftPow, double rightPow) {
    left.set(leftPow);
    right.set(rightPow);
    // leftFollow.set(ControlMode.Follower, 0);
    // rightFollow.set(ControlMode.Follower, 1);



  }

  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {}

  @Override
  public void periodic() {
    
    leftPower = OI.getArcJoy().getY();
    rightPower = OI.getArcJoy().getY();
    if(OI.getArcJoy().getX() < -0.2) {
      leftPower += -0.5;
      rightPower += 0.5;
    } else if (OI.getArcJoy().getX() > 0.2) {
      leftPower += 0.5;
      rightPower += -0.5;
    }

    tankDrive(leftPower * 0.3, rightPower * 0.3);
  }
}
