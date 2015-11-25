package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm
{
    private final double LowPressureTreshold = 17;
    private final double HighPressureTreshold = 21;
    private final Sensor sensor;

    boolean alarmOn = false;

    public Alarm(Sensor sensor) {
        this.sensor = sensor;
    }

    public void check()
    {
        double psiPressureValue = sensor.popNextPressurePsiValue();
        if (isPressureOverThreshold(psiPressureValue))
        {
            alarmOn = true;
        }
    }

    private boolean isPressureOverThreshold(double psiPressureValue) {
        return isPressureTooLow(psiPressureValue) || isPressureTooHigh(psiPressureValue);
    }

    private boolean isPressureTooHigh(double psiPressureValue) {
        return HighPressureTreshold < psiPressureValue;
    }

    private boolean isPressureTooLow(double psiPressureValue) {
        return psiPressureValue < LowPressureTreshold;
    }

    public boolean isAlarmOn()
    {
        return alarmOn; 
    }
}
