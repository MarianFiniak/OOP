import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class Sava {

    public void sava(Simple<Demain> arrayList,int M,String FILENAME) throws IOException {
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
    public Simple<Demain> resave(String FILENAME) throws IOException {
        FileReader fileReader = new FileReader(FILENAME);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        Simple<String> lines = new SimpleArray<>();
        String line = "";
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        bufferedReader.close();
        Simple<Demain> demains = new SimpleArray<>();
        int M=0;
        if(lines.size()>0) {
            M = Integer.parseInt(lines.get(0));
        }
        System.out.println(M);
        for (int j=0;j< M;j++){
     //       Demain demain =new Demain(lines);
      //      demains.add(demain);
        }
        return demains;

    }

}
