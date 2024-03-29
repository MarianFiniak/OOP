import javax.xml.bind.annotation.XmlRootElement;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

@XmlRootElement
public class Demain implements Serializable,Comparable<Demain> {
    int M;
    int N;
    Simple<Station> route = new SimpleArray<>();
    private String numberOfSeats;
    private String date;
    private String numberFlight;
    RedEx redEx = new RedEx();
    String s;


    public Demain() throws IOException

    {
        Station s2;
        Scanner in =new Scanner(System.in);
        System.out.println("Введіть номер рейсу " + " : ");
        String number = in.nextLine();
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
            Station station = new Station();
            route.add(station);
        }
    }



    public  Demain(ArrayList<String> lines, int k) throws IOException {
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
        s=redEx.date(date);
        if (s.equals(date)){
            this.date=date;
        }else {
            System.out.println("Error");
            this.date=s;
        }
    }

    public String getNumberFlight(){
        return numberFlight;
    }
    public void setNumberFlight(String numberFlight){
            this.numberFlight=numberFlight;

    }


    @Override
    public int compareTo(Demain o) {
        int number0= Integer.parseInt(this.getNumberFlight());
        int number1 = Integer.parseInt(o.getNumberFlight());
        return number0<number1?-1: (number0>number1)?1:0;
    }
}