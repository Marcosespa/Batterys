package model;

public class RechargeableBattery extends Battery implements Rechargeable{
    private int chargerNumber;
    private char type;

    //CONSTANTES 
    public final static char BATTERY_LITIO = 'l';
    public final static char BATTERY_NIQUEL_CADIO = 'n';
    public final static double FACTOR_LITIO = 0.92;
    public final static double FACTOR_NIQUEL_CADIO = 0.80;   
    
    public RechargeableBattery(String name, double voltage, double cost,double capacity, int chargerNumber,char type) {
        super(name, voltage,cost, capacity);
        this.chargerNumber=chargerNumber;
        this.type=type;
    }

    @Override
    public double calculateUsefulLifeCost() {
        double f=0;
        
        if(type=='l'){
            f= (getCost()*getVoltage()*getCapacity())/(1000*getChargerNumber()*FACTOR_LITIO) ;
        }
        if(type=='n'){
            f= (getCost()*getVoltage()*getCapacity())/(1000*getChargerNumber()*FACTOR_NIQUEL_CADIO) ;
        }        

        return f;
    }
    


    /**
     * @return int return the chargerNumber
     */
    public int getChargerNumber() {
        return chargerNumber;
    }

    /**
     * @param chargerNumber the chargerNumber to set
     */
    public void setChargerNumber(int chargerNumber) {
        this.chargerNumber = chargerNumber;
    }

    /**
     * @return char return the type
     */
    public char getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(char type) {
        this.type = type;
    }

}