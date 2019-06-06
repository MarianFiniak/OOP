import java.io.*;
import java.util.ArrayList;

public class Save {

    public void save(ArrayList<Demain> arrayList, int M, String FILENAME) throws IOException {
        FileWriter nFile = new FileWriter(FILENAME);
        nFile.write(M+"\n");
        for (int i = 0; i < arrayList.size(); i++) {
            nFile.write(arrayList.get(i).getNumberFlight()+"\n"+arrayList.get(i).getDate()+"\n"+
                    arrayList.get(i).getNumberOfSeats()+"\n"+arrayList.get(i).N+"\n");
            for (int j=0;j<arrayList.get(i).route.size();j++){
                nFile.write(arrayList.get(i).route.get(j).getNameStation()+"\n"+arrayList.get(i).route.get(j).getDateArrival()+"\n"+
                        arrayList.get(i).route.get(j).getDateDeparture()+"\n"+arrayList.get(i).route.get(j).getFreeSeat()+"\n");
            }
        }
        nFile.close();
    }
    public ArrayList<Demain> resave(String FILENAME) throws IOException {
        FileReader fileReader = new FileReader("file1.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        ArrayList<String> lines = new ArrayList<String>();
        String line = "";
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        bufferedReader.close();
        ArrayList<Demain> demains = new ArrayList<>();
        int M=0;
        if(lines.size()>0) {
            M = Integer.parseInt(lines.get(0));
        }
        for (int j=0;j< M;j++){
            Demain demain =new Demain(lines);
            demains.add(demain);
        }
        return demains;

    }
}
