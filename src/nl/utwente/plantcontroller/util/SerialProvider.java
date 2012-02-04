package nl.utwente.plantcontroller.util;

public final class SerialProvider {
    public static int serial = 0;
    
    public static int getNextSerial(){
        return serial++;
    }
}
