package itsa.patterns.sol;

import java.util.*;

import static org.junit.Assert.*;
import org.junit.*;

public class ObserverExample2Test {
	@Test
	public void testObserver() {
        SensorSystem2 sensorSystem = new SensorSystem2();
        sensorSystem.register(new Gates2());
        sensorSystem.register(new Lighting2());
        sensorSystem.register(new Surveillance2());
		
        String message = sensorSystem.soundTheAlarm();
		System.out.println(message);
		assert message.equals("Gates are activated.Lightings are activated.Surveillance are activated.") : "Sensors not working properly";
	
	}
}
