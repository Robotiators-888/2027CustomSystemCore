// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import org.wpilib.hardware.power.PowerDistribution;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import org.wpilib.command2.Command;
import org.wpilib.command2.Commands;
import org.wpilib.command2.InstantCommand;
import org.wpilib.command2.button.CommandNiDsXboxController;
import org.wpilib.command2.button.Trigger;
import frc.robot.Constants.Operator;


/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
        public static final PowerDistribution powerDistribution = new PowerDistribution(1);
        public SparkMax testMotor;
        // Xbox Controllers for driver input
        private final CommandNiDsXboxController Driver1 = new CommandNiDsXboxController(Operator.kDriver1ControllerPort);
        // private final CommandNiDsXboxController Driver2 = new CommandNiDsXboxController(Operator.kDriver2ControllerPort);
       
        /**
         * The container for the robot. Contains subsystems, OI devices, and commands.
         */
        public RobotContainer() {
                testMotor = new SparkMax(4,10,MotorType.kBrushless);
                configureBindings();
        }

        /**
         * Use this method to define your trigger->command mappings. Triggers can be
         * created via the
         * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with
         * an arbitrary
         * predicate, or via the named factories in
         * {@link org.wpilib.command2.button.CommandGenericHID}'s subclasses
         * for
         * {@link CommandXboxController
         * Xbox}/{@link org.wpilib.command2.button.CommandPS4Controller PS4}
         * controllers
         * or {@link org.wpilib.command2.button.CommandJoystick Flight
         * joysticks}.
         */
        private void configureBindings() {
                // =========================================================
                // DRIVER 1
                // =========================================================
                Driver1.leftTrigger().onTrue(
                        new InstantCommand(() -> testMotor.setThrottle(0.1))
                ).onFalse(
                        new InstantCommand(() -> testMotor.setThrottle(0))
                );
        }

        public void robotInit() {
                powerDistribution.setSwitchableChannel(true);
        }

        /**
         * Use this to pass the autonomous command to the main {@link Robot} class.
         *
         * @return the command to run in autonomous
         */
        public Command getAutonomousCommand() {
                return Commands.none();
        }

        public void robotPeriodic() {}

       
        public void autonomousInit() {}

        public void autonomousPeriodic() {}


        public void teleopInit() {}

        public void teleopPeriodic() {}

        public void disabledPeriodic() {
                testMotor.setThrottle(0);
        }

        

}
