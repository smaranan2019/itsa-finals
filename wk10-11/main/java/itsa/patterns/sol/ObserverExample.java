package itsa.patterns.sol;
import java.util.*;

interface AlarmListener {
    String alarm();
}

class SensorSystem {
    private List<AlarmListener> listeners = new ArrayList<AlarmListener>();

    public void register(AlarmListener alarmListener) {
        listeners.add(alarmListener);
    }

    public String soundTheAlarm() {
		String message = "";
        for (AlarmListener observer: listeners) {
            message += observer.alarm();
        }     
		return message;
    }
}

class Lighting implements AlarmListener {
    public String alarm() {
        System.out.println("Lightings are activated.");
		return "Lightings are activated.";
    }
}

class Gates implements AlarmListener {
    public String alarm() {
        System.out.println("Gates are activated.");
		return "Gates are activated.";
    }
}

class Surveillance implements AlarmListener {
    public String alarm() {
        System.out.println("Surveillance are activated.");
		return "Surveillance are activated.";
    }
}

public class ObserverExample {
    public static void main( String[] args ) {
        SensorSystem sensorSystem = new SensorSystem();
        sensorSystem.register(new Gates());
        sensorSystem.register(new Lighting());
        sensorSystem.register(new Surveillance());
		
        String message = sensorSystem.soundTheAlarm();
		System.out.println(message);
		assert message.equals("Gates are activated.Lightings are activated.Surveillance are activated.") : "Sensors not working properly";
	
	}
}
