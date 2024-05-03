package org.example;

public class BatteryCharger {
    //made variables and methods static for testing, original problem did not have this method be static
    private static int[] rateTable = {50,  60, 160,  60,  80, 100, 100, 120, 150, 150, 150, 200,
                               40, 240, 220, 220, 200, 200, 180, 180, 140, 100,  80,  60};
    private static int getChargingCost(int startHour, int chargeTime) {
        int currentIndex = startHour;
        int cost = 0;
        for(int i = 0; i<chargeTime; i++) {
            cost += rateTable[currentIndex];
            currentIndex++;
            if(currentIndex > 23) currentIndex = 0;
        }
        return cost;
    }

    public static int getChargeSTartTime(int chargeTime) {
        int timeOfCheapest = 0;
        int cheapestCost = Integer.MAX_VALUE;

        for(int startHour=0; startHour < 23; startHour++) {
            if(getChargingCost(startHour,chargeTime) < cheapestCost) {
                cheapestCost = getChargingCost(startHour,chargeTime);
                timeOfCheapest = startHour;
            }
        }
        return timeOfCheapest;
    }

    public static void main(String[] args) {
        System.out.println("--------------------------------------Part a-------------------------------------------");
        System.out.println("Stat Hour   Hours of Charge   Last Hour of Charge       Cost Should Be   Returned Cost");
        System.out.println("   12             1                 12                        40               "
                           +getChargingCost(12,1));
        System.out.println("   0              2                 1                         110              "
                           +getChargingCost(0,2));
        System.out.println("   22             7                 4 (next day)              550              "
                           +getChargingCost(22,7));
        System.out.println("   22             30                3 (two days later)        3710             "
                           +getChargingCost(22,30));

        System.out.println("--------------------------------------Part b-------------------------------------------");
        System.out.println("Charge Time   Minimum Cost         Start Hour   Last Hour of Charge Returned Start Hour");
        System.out.println("   1              40                  12                        12             "
                           +getChargeSTartTime(1));
        System.out.println("                                      0                         1              \n"+
                           "   2              110                         or                               "
                           +getChargeSTartTime(2) + "\n" +
                           "                                      23                        0              "
                           );
        System.out.println("   7              550                 22                        4              "
                           +getChargeSTartTime(7));
        System.out.println("   30             3710                22                        3              "
                           +getChargeSTartTime(30));
    }
}
