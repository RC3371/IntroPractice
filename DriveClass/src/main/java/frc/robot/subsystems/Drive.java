package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import com.ctre.phoenix.motorcontrol.can.TalonFX;

import frc.robot.*;

public class Drive extends Subsystem {
    int idLMaster = 0;
    int idLSlave = 1;
    int idRMaster = 2;
    int idRSlave = 3;

    TalonFX LMaster = new TalonFX(idLMaster);
    TalonFX LSlave = new TalonFX(idLSlave);
    TalonFX RMaster = new TalonFX(idRMaster);
    TalonFX RSlave = new TalonFX(idRSlave);

    public Drive(){
        LSlave.set(ControlMode.Follower, idLMaster);
        RSlave.set(ControlMode.Follower, idRMaster);
    }

    public void Stop(){
        LMaster.set(ControlMode.PercentOutput, 0.0);
        RMaster.set(ControlMode.PercentOutput, 0.0);
    }

    public void setOpenLoop(double throttle, double turn){
        //negative turn value = right, positive turn value = left
        //negative throttle value = backward, positive throttle value = forward

        if(throttle > 0){
            LMaster.set(ControlMode.PercentOutput, (-throttle+turn)/2);
            RMaster.set(ControlMode.PercentOutput, (throttle+turn)/2);
        }
        else if(throttle < 0){
            LMaster.set(ControlMode.PercentOutput, (throttle+turn)/2);
            RMaster.set(ControlMode.PercentOutput, (-throttle+turn)/2);
        }
        else{
            LMaster.set(ControlMode.PercentOutput, 0.0);
            RMaster.set(ControlMode.PercentOutput, 0.0);
        }

    }
    //Quickturn
    public void QuickTurn(double turnValue){
        LMaster.set(ControlMode.PercentOutput, turnValue);
        RMaster.set(ControlMode.PercentOutput, turnValue);
    }

    public static boolean epsilonEquals(final double a, final double b, final double epsilon) {
        final double diff = a - b;
        return diff < epsilon && diff > 0d - epsilon;
    }

    public synchronized void setCheesyishDrive(double throttle, double wheel, boolean quickTurn) {
        if (epsilonEquals(throttle, 0.0, 0.04)) {
            throttle = 0.0;
        }
    }

}

