import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Station {
    private String nameStation;
    private String dateArrival;
    private String dateDeparture;
    private String freeSeat;
    public Station() throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Введіть назву "  + " станції: ");
        String station = in.nextLine();
        setNameStation(station);
        System.out.println("Введіть час прибуття на станцію " + station + " : ");
        String arraive = in.nextLine();
        setDateArrival(arraive);
        System.out.println("Введіть час відправлення на станції " + station + " : ");
        String departure = in.nextLine();
        setDateDeparture(departure);
        System.out.println("Введіть кількість вільних місць: ");
        String freePlaces = in.nextLine();
        setFreeSeat(freePlaces);
    }
    public Station(ArrayList<String> lines,int i){

            setNameStation(lines.get(i));
            i++;
            setDateArrival(lines.get(i));
            i++;
            setDateDeparture(lines.get(i));
            i++;
            setFreeSeat(lines.get(i));
            i++;

    }

    public String getNameStation(){
        return nameStation;
    }
    public String getDateArrival(){
        return dateArrival;
    }
    public String getDateDeparture(){
        return dateDeparture;
    }
    public String getFreeSeat(){return freeSeat;}

    public void setNameStation(String nameStation){this.nameStation= nameStation;}
    public void setDateArrival(String dateArrival){this.dateArrival=dateArrival;}
    public void setDateDeparture(String dateDeparture){this.dateDeparture=dateDeparture;}
    public void setFreeSeat(String freeSeat){this.freeSeat=freeSeat;}
}
