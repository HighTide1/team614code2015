package org.usfirst.frc.team614.robot.commands;

import org.usfirst.frc.team614.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CloseArms extends Command {

	
	private static boolean firstTime;
	private static double timeout;
	
    public CloseArms(double time) {
    	
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.pneumatics);
    	timeout = time;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	firstTime = true;
    	setTimeout(timeout);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	
    	if(firstTime && Robot.pneumatics.getPistonState()){ //only close the arms if the piston is already open
    		Robot.pneumatics.retractPiston();
    		firstTime = false;
    	}
    	
    		
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
