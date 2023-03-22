import java.io.*;
import java.util.*;
import java.util.Vector;

public class Ship {
    private String name =" ";
    private double total_distance=0;
    Vector record= new Vector();
    private int currx=0;
    private int curry=0;
    private int desx;
    private int desy;
    private double num=0;
    public void enterName(){
        System.out.println("please enter your ship's name");
        Scanner obj1 = new Scanner(System.in);
        name = obj1.nextLine();
        System.out.println("your ship's name: " + name);
        setname(name);

    }
    public void enterCoordinate(){
        System.out.println("enter x coordinate");
        Scanner obj = new Scanner(System.in);
        desx = obj.nextInt();
        System.out.println("enter y coordinate");
        Scanner obj1 = new Scanner(System.in);
        desy = obj1.nextInt();
        view_OR_travel();

    }
    public void view_OR_travel(){
        int z=0;
        do {
            System.out.println("1.View distance 2.Travel to destination 3.back");
            Scanner obj2 = new Scanner(System.in);
            z = obj2.nextInt();
            switch (z){
                case 1:{
                    double dis = calculate(desx,desy);//view distance
                    System.out.println("The distance is "+dis);
                    break;
                }
                case 2:{
                    calculate(desx,desy);
                    setposition(desx,desy);//travel
                    System.out.println(name+" has arrived");
                    System.out.println("Save the logs?"+"\n");
                    save_logs();
                    return;
                }
                case 3: return;
                default:{
                    System.out.println("error");
                }
            }


        }while (z!=3);
    }



    public void loadlogs(){
        int z=0;
        do {
            System.out.println("1.All destination point(where the ship have been) 2.The total distance 3.back");
            Scanner obj = new Scanner(System.in);
            z = obj.nextInt();
            switch (z) {
                case 1: {
                    //if no logs exists
                    if(record.size()==0){
                        System.out.println("There is no record");
                        break;
                    }
                    //load the logs
                    else{
                        for(int i=0;i< record.size();i++){
                            System.out.println(record.get(i));

                        }
                    }
                    break;
                }
                case 2: {
                    System.out.println("Total distance: "+ total_distance);//show total distance
                    break;
                }
                case 3: return;
                default:{
                    System.out.println("error");
                }
            }
        }while(z!=3);
    }
    public void save_logs() {
        String coor = "(" + currx + "," + curry + ")";
        int z=0;
        do {
            System.out.println("1.Yes 2.No");
            Scanner obj = new Scanner(System.in);
            z = obj.nextInt();
            switch (z) {
                case 1: {
                    System.out.println("Saving log");
                    record.add(coor);//save the logs
                    total_distance += num;
                    return;
                }

                case 2: return;

                default: {
                    System.out.println("error");
                }

            }
    }while(z!=2);

    }
    public void setname(String Name){ name = Name;}
    public String getname(){return name;}
    public void setposition(int x1, int y1){
        currx = x1;
        curry = y1;
    }

    public double calculate(int x1, int y1){

        double x2 = Math.pow(currx-x1,2);
        double y2 = Math.pow(curry-y1,2);
        num = Math.sqrt(x2+y2);

        return num;
    }
}
