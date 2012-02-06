package nl.utwente.plantcontroller.util;

public final class SerialProvider {
    public static int serial = 0;
    
    /**
     * Bewaakt een zeker serial, elk serial is uniek
     * @return
     */
    public static int getNextSerial(){
        return serial++;
    }
}
