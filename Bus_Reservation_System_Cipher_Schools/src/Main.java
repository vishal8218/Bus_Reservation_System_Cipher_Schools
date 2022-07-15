import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        int bus_n;
        String name, sor, des, date;
        int fair, seats;
        Scanner sc = new Scanner(System.in);
        BusDetails[] bus = new BusDetails[1];
        for (int i = 0; i < bus.length; i++) {
            int j=i+1;
            System.out.println("Enter the "+j+" Bus Details of ");
            bus[i] = new BusDetails();
            bus_n = sc.nextInt();
            name = sc.next();
            sor = sc.next();
            des = sc.next();
            date = sc.next();
            seats = sc.nextInt();
            //   fair = sc.nextInt();
            bus[i].setBus_Number(bus_n, seats);
            bus[i].setName(name);
            bus[i].setSource(sor);
            bus[i].setDes(des);
            bus[i].setDate(date);
            bus[i].setPrice(sor,des);
        }
        BusDetails object1 = new BusDetails();
        object1.bus_details(bus);// Display List of Buses
        System.out.println("Sign-in");
        Passenger[] pass=new Passenger[1];
        for(int i=0;i<pass.length;i++)
        {
            int j=i+1;
            System.out.println("Enter the "+j+" User Details ");
            pass[i]=new Passenger();
            pass[i].signin();
        }
        Passenger log=new Passenger();
        System.out.println("********** User Details ***********");
        System.out.println("Name\tMobile_Number\tEmail-id\tPassword\t\tStreet\tState\tNumber_of_Seats");
        log.display_user_details(pass);
        System.out.println("Enter email-id and password for login");
        String email=sc.next();
        String password=sc.next();
        if(log.login(email,password,pass))
        {
            System.out.println("Login Successfully!!!");
            System.out.println("1.Book a Ticket ");
            System.out.println("2. Exit");
            System.out.println("Enter your choice");
            int s=sc.nextInt();
            switch (s)
            {
                case 1:
                    String sou=sc.next();
                    String des1=sc.next();
                    String date1=sc.next();
                    int s1=sc.nextInt();
                    if(log.BookingTicket(sou,des1,date1,s1,bus,pass))
                    {
                        System.out.println("Book Ticket Successfully!!");
                    }
                    else {
                        System.out.println("Ticket are not Booked");
                    }
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Please enter a vaild Entry");
                    break;
            }

        }
        System.out.println("1.Update user details");
        System.out.println("2.Cancel a Ticket");
        System.out.println("Enter Your Choice ");
        int choice=sc.nextInt();
        switch(choice)
        {
            case 1:
                String email1=sc.next();
                String password1=sc.next();
                log.update(email1,password1,pass);
                break;
            case 2:
                long m=sc.nextLong();
                String email2=sc.next();
                log.cancelTicket(m,email2,pass);
                break;
            default:
                System.out.println("Please Enter a valid Entry");
                break;
        }
        System.out.println("********** User Details ***********");
        System.out.println("Name\tMobile_Number\tEmail-id\tPassword\tStreet\tState\tNumber_of_Seats");
        log.display_user_details(pass);

    }
}



