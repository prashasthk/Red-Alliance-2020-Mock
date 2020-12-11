/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.OI;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.PWMTalonSRX;

/**
 * Add your docs here.
 */
public class BallShooter extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private PWMTalonSRX gateWheelRight = new PWMTalonSRX(2);
  private PWMTalonSRX gateWheelLeft = new PWMTalonSRX(3);
  private PWMTalonSRX flyWheelLeft = new PWMTalonSRX(4);
  private PWMTalonSRX flyWheelRight = new PWMTalonSRX(5);

  

  public static BallShooter shooter;

  public BallShooter() {}

  public static BallShooter getInstance() {
    if (shooter == null) {
      shooter = new BallShooter();
    }
    return shooter;
  }

  public void spinGateWheels(double speed) {
    gateWheelLeft.set(speed);
    gateWheelRight.set(speed);
  }

  public void spinFlyWheels(double speed) {
    flyWheelLeft.set(speed);
    flyWheelRight.set(-speed);
  }



  @Override
  public void initDefaultCommand() {}

  @Override
  public void periodic() {
    if (OI.getArcJoy().getRawButton(RobotMap.inButton)){
      spinGateWheels(-0.2);
    } else if (OI.getArcJoy().getRawButton(RobotMap.outButton)){
      spinFlyWheels(0.2);
    } else {
      spinGateWheels(0);
      spinFlyWheels(0);
    
  }
  }
}
