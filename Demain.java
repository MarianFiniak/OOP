import javax.xml.bind.annotation.XmlRootElement;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

@XmlRootElement
public class Demain {
    int M;
    int N;
    static int i=1;
    ArrayList<Station> route = new ArrayList<Station>();
    private String numberOfSeats;
    private String date;
    private String numberFlight;
    FileWriter nFile = new FileWriter("file1.txt");


    public Demain() throws IOException {
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



    public  Demain(ArrayList<String> lines) throws IOException {
        System.out.println(i);
            setNumberFlight(lines.get(i));
            i++;
            setDate(lines.get(i));
            i++;
            setNumberOfSeats(lines.get(i));
            i++;
            N= Integer.parseInt(lines.get(i));
            i++;
            for (int j = 0;j<N;j++){
                Station station = new Station(lines,i);
                route.add(station);
                i+=4;
            }

    }



    public String getNumberOfSeats() {
        return numberOfSeats;
    }
    public void setNumberOfSeats(String places){
        numberOfSeats=places;
    }

    public String getDate(){
        return date;
    }
    public void setDate(String date){
        this.date = date;
    }

    public String getNumberFlight(){
        return numberFlight;
    }
    public void setNumberFlight(String numberFlight){
        this.numberFlight=numberFlight;
    }


}