package tddmicroexercises.tirepressuremonitoringsystem;


import org.hamcrest.MatcherAssert;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AlarmShould {

    private static final double OK_PRESSURE_VALUE = 20;
    private static final double HIGH_PRESSURE_VALUE = 22;
    private static final double LOW_PRESSURE_VALUE = 16;
    private TestableAlarm alarm;
    @Mock Sensor sensor;

    @Before
    public void init(){
        alarm = new TestableAlarm(sensor);
    }

    @Test
    public void
    be_off_when_pressure_is_OK() {
        when(sensor.popNextPressurePsiValue()).thenReturn(OK_PRESSURE_VALUE);

        alarm.check();

        assertThat(alarm.isAlarmOn(), is(false));
    }

    @Test public void
    be_on_when_pressure_is_high() {
        when(sensor.popNextPressurePsiValue()).thenReturn(HIGH_PRESSURE_VALUE);

        alarm.check();

        assertThat(alarm.isAlarmOn(), is(true));
    }

    @Test public void
    be_on_when_pressure_is_low() {
        when(sensor.popNextPressurePsiValue()).thenReturn(LOW_PRESSURE_VALUE);

        alarm.check();

        assertThat(alarm.isAlarmOn(), is(true));
    }

    private class TestableAlarm extends Alarm{
        private double pressure;
        private Sensor sensor;

        public TestableAlarm(Sensor sensor) {
            this.sensor = sensor;
        }

        @Override
        protected double popNextPressurePsiValue() {
            return sensor.popNextPressurePsiValue();
        }
    }
}
