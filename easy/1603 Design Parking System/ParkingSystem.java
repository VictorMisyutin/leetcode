class ParkingSystem {
    public int bigSlots, mediumSlots, smallSlots = 0;

    public ParkingSystem(int big, int medium, int small) {
        bigSlots = big;
        mediumSlots = medium;
        smallSlots = small;
    }
    
    public boolean addCar(int carType) {
        switch (carType){
            case 1:
                if(bigSlots > 0){
                    bigSlots--;
                    return true;
                }
                break;
            case 2:
                if(mediumSlots > 0){
                    mediumSlots--;
                    return true;
                }
                break;
            case 3:
                if(smallSlots > 0){
                    smallSlots--;
                    return true;
                }
        }
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */