import java.util.HashMap;
import java.util.Scanner;

public class BusDetails {
    protected int bus_Number;
    protected  String name;
    protected String source;
    protected  String des;

    protected  String date;
    Scanner sc=new Scanner(System.in);
    int seats[]=new int [5];
    static int c=0;
    HashMap<String,Integer>fair=new HashMap<>();
    public void setBus_Number(int bus_Number,int  se) {
        this.bus_Number = bus_Number;
        seats[c++]=se;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public void setDes(String des) {
        this.des = des;
    }
    public void setDate(String d) {
        this.date = d;
    }public int getBus_Number() {
        return bus_Number;
    }
    public int getSeats(int i)
    {
        return seats[i];
    }
    public void setPrice(String sou,String des)
    {
        int ammount;
        ammount=sc.nextInt();
        fair.put(sou,ammount);

    }
    public int getPrice(String sou,String des)
    {
        return(fair.get(sou));
    }


    public String getName() {
        return name;
    }
    public String getSource() {
        return source;
    }

    public String getDes() {
        return des;
    }
    public String getDate(){return date;}
    void bus_details(BusDetails b[])
    {
        System.out.println("Bus_Number "+"Operator_Name "+"Source "+"Destination "+"Fair "+"Seats_Availbility ");
        for(int i=0;i<b.length;i++)
        {
            System.out.println(b[i].getBus_Number()+"\t\t"+b[i].getName()+" \t\t"+b[i].getSource()+"\t "+b[i].getDes()+"\t"+b[i].getPrice(b[i].getSource(),b[i].getDes())+"\t\t\t"+b[i].getSeats(i));
        }
    }
}
class Passenger extends BusDetails {
    protected String name;
    protected long moblie_number;
    protected String email, password, street, state;
    int seat;

    public void setName1(String name) {
        this.name = name;
    }

    public void setMoblie_number(long moblie_number) {
        this.moblie_number = moblie_number;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String p) {
        this.password = p;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setSeat(int s) {
        this.seat = s;
    }

    public String getName1() {
        return name;
    }

    public long getMoblie_number() {
        return moblie_number;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getStreet() {
        return street;
    }

    public String getState() {
        return state;
    }

    public int getSeat() {
        return this.seat;
    }

    public void signin() {
        String name;
        long mob;
        String email, pass, st, sta;
        Scanner sc = new Scanner(System.in);
        name = sc.next();
        mob = sc.nextLong();
        email = sc.next();
        pass = sc.next();
        st = sc.next();
        sta = sc.next();
        this.setName1(name);
        this.setMoblie_number(mob);
        this.setEmail(email);
        this.setPassword(pass);
        this.setStreet(st);
        this.setState(sta);
        // System.out.println("Sign In Successfully!!!");
    }

    public Boolean login(String email, String password, Passenger pass[]) {
        int f = 0;
        for (int i = 0; i < pass.length; i++) {
            if (email.equals(pass[i].getEmail()) && password.equals(pass[i].getPassword())) {
                f = 1;
                break;
            }
        }

        if (f == 1) {
            return true;
        } else {
            return false;
        }

    }

    public Boolean BookingTicket(String sour, String des, String date, int seat, BusDetails b[],Passenger p[]) {
        Boolean f = false;
        for (int i = 0; i < b.length; i++) {
            if (sour.equals(b[i].getSource()) && des.equals(b[i].getDes()) && date.equals(b[i].getDate()) && seat <= b[i].getSeats(i)) {
                p[i].setSeat(seat);
                f = true;
                break;
            }
        }
        return f;


    }

    public void update(String email, String pass, Passenger obj[]) {
        if (login(email, pass, obj)) {
            int n;
            System.out.println("Choose which detail you want to update");
            System.out.println("1.Name\n2.Mobile_Number\n3.email\n4.Password");
            n = sc.nextInt();
            switch (n) {
                case 1: {
                    name = sc.next();
                    for(int i=0;i<obj.length;i++) {

                        if(email.equals(obj[i].getEmail()))
                        {
                            obj[i].setName1(name);
                            break;
                        }
                    }
                    break;
                }
                case 2: {
                    moblie_number = sc.nextLong();
                    for(int i=0;i<obj.length;i++) {

                        if(email.equals(obj[i].getEmail()))
                        {
                            obj[i].setMoblie_number(moblie_number);
                            break;
                        }
                    }
                    break;
                }
                case 3: {
                    email = sc.next();
                    for(int i=0;i<obj.length;i++) {

                        if(email.equals(obj[i].getEmail()))
                        {
                            obj[i].setEmail(email);
                            break;
                        }
                    }
                    break;
                }
                case 4: {
                    password = sc.next();
                    for(int i=0;i<obj.length;i++) {

                        if(email.equals(obj[i].getEmail()))
                        {
                            obj[i].setPassword(password);
                            break;
                        }
                    }
                    break;
                }
                default: {
                    System.out.println("Please Enter valid Entry");
                    break;
                }
            }
        } else {
            System.out.println("Please Enter Correct email or password");
        }

    }

    public void cancelTicket(long moblie_number, String email, Passenger p[]) {
        int f = 0;
        for (int i = 0; i < p.length; i++) {
            if (p[i].getMoblie_number() == moblie_number && p[i].getEmail() == email) {
                int s = p[i].getSeat();
                s = s - p[i].getSeat();
                p[i].setSeat(s);
                System.out.println("Cancel Ticket Successfully!!!!");
                f = 1;
                break;

            }
        }
        if (f == 0) {
            System.out.println("Not Book any Ticket Till now from user side");
        }
    }

    public void display_user_details(Passenger p[])
    {
        for(int i=0;i<p.length;i++)
        {
            System.out.println(p[i].getName1()+"\t"+p[i].getMoblie_number()+"\t"+p[i].getEmail()+"\t"+p[i].getPassword()+"\t\t"+p[i].getStreet()+"\t\t"+p[i].getState()+"\t\t"+p[i].getSeat());

        }
    }
}


