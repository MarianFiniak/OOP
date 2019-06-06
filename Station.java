import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

public class Station implements Serializable {
    private String nameStation;
    private String dateArrival;
    private String dateDeparture;
    private String freeSeat;
    RedEx redEx = new RedEx();
    String s;
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
    public Station(Simple<String> lines,int i){

            setNameStation(lines.get(i));
            i++;
            setDateArrival(lines.get(i));
            i++;
            setDateDeparture(lines.get(i));
            i++;
            setFreeSeat(lines.get(i));

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

    public void setNameStation(String nameStation){
        s=redEx.station(nameStation);
        if (s.equals(nameStation)){
            this.nameStation=nameStation;
        }else {
            System.out.println("Error");
            this.nameStation=s;
        }
    }
    public void setDateArrival(String dateArrival){
        s=redEx.time(dateArrival);
        if (s.equals(dateArrival)){
            this.dateArrival=dateArrival;
        }else {
            System.out.println("Error");
            this.dateArrival=s;
        }
    }
    public void setDateDeparture(String dateDeparture){
        s=redEx.time(dateDeparture);
        if (s.equals(dateDeparture)){
            this.dateDeparture=dateDeparture;
        }else {
            System.out.println("Error");
            this.dateDeparture=s;
        }
    }
    public void setFreeSeat(String freeSeat){
        s=redEx.seat(freeSeat);
        if (s.equals(freeSeat)){
            this.freeSeat=freeSeat;
        }else {
            System.out.println("Error");
            this.freeSeat=s;
        }}
}
