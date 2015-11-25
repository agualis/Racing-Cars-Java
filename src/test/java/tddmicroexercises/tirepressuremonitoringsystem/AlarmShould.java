package tddmicroexercises.tirepressuremonitoringsystem;


import org.hamcrest.MatcherAssert;
import org.junit.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AlarmShould {

    private static final double OK_PRESSURE_VALUE = 20;
    private static final double HIGH_PRESSURE_VALUE = 22;
    private static final double LOW_PRESSURE_VALUE = 16;
    private TestableAlarm alarm;

    @Before
    public void init(){
        alarm = new TestableAlarm();
    }

    @Test
    public void
    be_off_when_pressure_is_OK() {
        alarm.mockPressure(OK_PRESSURE_VALUE);

        alarm.check();

        assertThat(alarm.isAlarmOn(), is(false));
    }

    @Test public void
    be_on_when_pressure_is_high() {
        alarm.mockPressure(HIGH_PRESSURE_VALUE);

        alarm.check();

        assertThat(alarm.isAlarmOn(), is(true));
    }

    @Test public void
    be_on_when_pressure_is_low() {
        alarm.mockPressure(LOW_PRESSURE_VALUE);

        alarm.check();

        assertThat(alarm.isAlarmOn(), is(true));
    }

    private class TestableAlarm extends Alarm{
        private double pressure;

        @Override
        protected double popNextPressurePsiValue() {
            return pressure;
        }

        public void mockPressure(double pressure) {
            this.pressure = pressure;
        }
    }
}
