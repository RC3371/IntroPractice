package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonFX;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import frc.robot.Constants;

public class FlyWheel {

    TalonFX wMaster = new TalonFX(Constants.wMid);
    TalonFX wSlave = new TalonFX(Constants.wSid);

    public FlyWheel() {
        wSlave.set(ControlMode.Follower, Constants.wMid);

        wMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, Constants.pidIdx, Constants.timeoutMs);
        wMaster.config_kD(Constants.slotIdx, Constants.value);
        wMaster.config_kF(Constants.slotIdx, Constants.value);
        wMaster.config_kI(Constants.slotIdx, Constants.value);
        wMaster.config_kP(Constants.slotIdx, Constants.value);
    }

    public class PeriodicIO {
        double velocity_ticks = 0.0;
        double outVelocity  = 0.0;
    }

    private PeriodicIO mPeriodicIO = new PeriodicIO();
    

}

    