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
        double psiPressureValue = popNextPressurePsiValue();

        if (psiPressureValue < LowPressureTreshold || HighPressureTreshold < psiPressureValue)
        {
            alarmOn = true;
        }
    }

    protected double popNextPressurePsiValue() {
        return sensor.popNextPressurePsiValue();
    }

    public boolean isAlarmOn()
    {
        return alarmOn; 
    }
}
