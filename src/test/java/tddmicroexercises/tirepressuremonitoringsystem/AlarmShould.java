package tddmicroexercises.tirepressuremonitoringsystem;


import org.junit.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AlarmShould {

    @Test
    public void
    beOffWhenTemperatureIsInsideThreshold() {
        Alarm alarm = new Alarm();
        alarm.check();
        assertThat(alarm.isAlarmOn(), is(false));
    }
}
