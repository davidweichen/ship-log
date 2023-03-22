import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int z = 0;
        System.out.println("Welcome to ship log"+"\n");
        Ship ship = new Ship();
        do {
            System.out.println("Please enter the number"+"\n");
            System.out.println("1.Enter ship's name 2.Enter Coordinate 3.Load logs 4.Coordinate instructions 5.End"+"\n");
            Scanner obj = new Scanner(System.in);
            z = obj.nextInt();
            switch (z){
                case 1:{
                    ship.enterName();
                    break;
                }
                case 2:{
                    ship.enterCoordinate();
                    break;
                }
                case 3:{
                    ship.loadlogs();
                    break;
                }
                case 4:{
                    System.out.println("X positive: East");
                    System.out.println("X negative: West");
                    System.out.println("Y positive: North");
                    System.out.println("Y positive: South");
                    break;
                }
            }
        }while(z!=5);

    }
}