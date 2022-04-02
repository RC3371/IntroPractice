package frc.robot;

import com.ctre.phoenix.Util;

import edu.wpi.first.wpilibj.Timer;


public class PIDF {
    double mP, mI, mD, mF;
    double mSetPoint;
    double error;
    double TimeStamp = Timer.getFPGATimestamp();
    double previousTime;
    double integral, derivative;
    double previousError;
    double output;

    public PIDF(double kF, double kD, double kI, double kP){
        this.mF = kF;
        this.mD = kD;
        this.mI = kI;
        this.mP = kP;
    }

    public double getP(){
        return mP;
    }
    public void setP(double kP){
        mP = kP;
    }
    public double getI(){
        return mI;
    }
    public void setI(double kI){
        mI = kI;
    }
    public double getD(){
        return mD;
    }
    public void setD(double kD){
        mD = kD;
    }
    public double getF(){
        return mF;
    }
    public void setF(double kF){
        mF = kF;
    }

    public void getPosition(){
    }

    public double getSetPoint(){
        return mSetPoint;
    }

    public void setSetPoint(double setpoint){
        mSetPoint = setpoint;
    }

    public double update(double currentPos) throws InterruptedException {
        error = mSetPoint-currentPos;
        long dt = (long) TimeStamp - (long) previousTime;
        dt = (long) TimeStamp - (long) previousTime;
        error = mSetPoint-currentPos;
        integral = integral + error * dt;
        derivative = (error - previousError) / dt;
        output = mP*error + mI*integral + mD*derivative;
        previousError = error;
        wait(dt);
        previousTime = TimeStamp;
        return output;
    }


    
}
