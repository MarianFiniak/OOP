import javax.xml.bind.annotation.XmlRootElement;
import java.io.IOException;
import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;

@XmlRootElement
public class Demain implements Serializable {
    int M;
    int N;
    Simple<Station> route = new SimpleArray<>();
    private String numberOfSeats;
    private String date;
    private String numberFlight;
    RedEx redEx = new RedEx();
    String s;
    Random r = new Random();


    public Demain() throws IOException

    {
        //Station s2;
        Scanner in =new Scanner(System.in);
        System.out.println("Введіть номер рейсу " + " : ");
        String number = String.valueOf(r.nextInt(99999-10000)+10000);
        System.out.println(number);
        setNumberFlight(number);
        System.out.println("Введіть дату прибуття: ");
        String date = String.valueOf(r.nextInt(999999-100000)+100000);
        System.out.println(date);
        setDate(date);
        System.out.println("Введіть кількість місць");
        String places = String.valueOf(r.nextInt(9999-1000)+1000);
        System.out.println(places);
        setNumberOfSeats(places);
        System.out.println("Введіть кіскість зупинок(включно з початкової і кінцевої): ");
        N = r.nextInt(10-2)+2;
        for (int i = 0; i < N; i++) {
            Station station = new Station();
            route.add(station);
        }
    }

    public Demain(String s) throws IOException

    {
        //Station s2;
        Scanner in =new Scanner(System.in);
        System.out.println("Введіть номер рейсу " + " : ");
        String number =in.nextLine();
        setNumberFlight(number);
        System.out.println("Введіть дату прибуття: ");
        String date = in.nextLine();
        setDate(date);
        System.out.println("Введіть кількість місць");
        String places = in.nextLine();
        setNumberOfSeats(places);
        System.out.println("Введіть кіскість зупинок(включно з початкової і кінцевої): ");
        N = in.nextInt();
        for (int i = 0; i < N; i++) {
            Station station = new Station("");
            route.add(station);
        }
    }



    public  Demain(Simple<String> lines,int k) throws IOException {
        //System.out.println(i);

        setNumberFlight(lines.get(0));

        setDate(lines.get(1));
        setNumberOfSeats(lines.get(2));
        this.N = k;
        int i =4;
        for (int j = 0; j < N; j++) {

            Station station = new Station(lines, i);
            route.add(station);
            i += 4;
        }
    }


    public String getNumberOfSeats() {
        return numberOfSeats;
    }
    public void setNumberOfSeats(String places){
        s=redEx.seat(places);
        if (s.equals(places)) {
            numberOfSeats = places;
        }else {
            System.out.println("Error");
            numberOfSeats =s;
        }
    }

    public String getDate(){
        return date;
    }
    public void setDate(String date){
            this.date=date;

    }

    public String getNumberFlight(){
        return numberFlight;
    }
    public void setNumberFlight(String numberFlight){
        s=redEx.nameF(numberFlight);
        if (s.equals(numberFlight)){
            this.numberFlight=numberFlight;
        }else {
            System.out.println("Error");
            this.numberFlight=s;
        }

    }


}