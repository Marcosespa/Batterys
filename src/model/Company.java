package model;

public class Company{
	
    public static final int MAX_BATTERIES = 10;
	private Battery[] batteries;

	public Company() {
        this.batteries = new Battery[MAX_BATTERIES];
	}

    public Company(Battery[] batteries){
        this.batteries = batteries;
    }
	

    public void registerBattery(String name, double voltage, double cost, double capacity){
        int emtyPos = getEmtyPosition();
        batteries[emtyPos] = new Battery(name, voltage, cost, capacity);

    }

    public void registerRechargeableBattery(String name, double voltage, double cost, double capacity, int chargerNumber, char type) {
        int emtyPos = getEmtyPosition();

        batteries[emtyPos] = new RechargeableBattery(name, voltage, cost, capacity, chargerNumber ,type);
        
    }
    
    private int getEmtyPosition() {
        int pos = -1;
        for (int i = 0; i < MAX_BATTERIES && pos == -1; i++) {
            if (batteries[i] == null) {
                pos = i;
            }
        }
        return pos;
    }

    public String showTotalBatteries() {
        int RechargeableBatteryAmount=0;
        int BatteryAmount=0;
        String out="";

        for (int i = 0; i < MAX_BATTERIES ; i++) {
            if(batteries[i] instanceof RechargeableBattery){
                RechargeableBatteryAmount++;
            }
            if(batteries[i] instanceof Battery){
                BatteryAmount++;
            }
        }
        out="The total amount of Rechargeable Battery it's "+ RechargeableBatteryAmount +
        "\n"+"The total amount of normal Battery it's " + BatteryAmount ;

    	return out;
    }
    
    public String showBatteriesInfo() {
    	String str = "";
        for (int i = 0; i < MAX_BATTERIES ; i++) {
            if(batteries[i] instanceof RechargeableBattery){
                str+= "The batery it's of type Rechargable \n"+
                "\n Name"+ ((RechargeableBattery)batteries[i]).getName()+
                "\n Costo de vida util "+  ((RechargeableBattery)batteries[i]).calculateUsefulLifeCost();
            }
            if(batteries[i] instanceof Battery){
                str+= "The batery it's of type Normal \n"+
                "\n Name"+ ((Battery)batteries[i]).getName()+
                "\n Costo de vida util "+ 0;
            }
        }        
        
    	return str;
    }
    

	public double calculateUsefulPromLifeCost(){
        double prom=0;
        double prom2=0;
        int RechargeableBatteryAmount=0;

        for (int i = 0; i < MAX_BATTERIES ; i++) {
            if(batteries[i] instanceof RechargeableBattery){
                // msg += ((Chicken)animals.get(i)).run() + "\n";
                prom+= ((RechargeableBattery)batteries[i]).calculateUsefulLifeCost();
                RechargeableBatteryAmount++;
            }
        }
        prom2=prom/RechargeableBatteryAmount;

		return prom2;
	}

}
