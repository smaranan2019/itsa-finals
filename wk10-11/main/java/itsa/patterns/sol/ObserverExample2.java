package itsa.patterns.sol;
import java.util.*;

interface AlarmListener2 {
    String alarm();
}

class SensorSystem2 {
    private Vector<AlarmListener2> listeners = new Vector<AlarmListener2>();

    public void register(AlarmListener2 alarmListener) {
        listeners.addElement(alarmListener);
    }

    public String soundTheAlarm() {
		String message = "";
        for (Enumeration e = listeners.elements(); e.hasMoreElements();) {
            message +=((AlarmListener2) e.nextElement()).alarm();
        }
		return message;
    }
}

class Lighting2 implements AlarmListener2 {
    public String alarm() {
        System.out.println("Lightings are activated.");
		return "Lightings are activated.";
    }
}

class Gates2 implements AlarmListener2 {
    public String alarm() {
        System.out.println("Gates are activated.");
		return "Gates are activated.";
    }
}

class Surveillance2 implements AlarmListener2 {
    public String alarm() {
        System.out.println("Surveillance are activated.");
		return "Surveillance are activated.";
    }
}

public class ObserverExample2 {
    public static void main( String[] args ) {
        SensorSystem2 sensorSystem = new SensorSystem2();
        sensorSystem.register(new Gates2());
        sensorSystem.register(new Lighting2());
        sensorSystem.register(new Surveillance2());
		
        String message = sensorSystem.soundTheAlarm();
		System.out.println(message);
		assert message.equals("Gates are activated.Lightings are activated.Surveillance are activated.") : "Sensors not working properly";
	
	}
}
