import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Search extends Thread{
    ConstructorsForXML constructorsForXML=new ConstructorsForXML();
    long timeStart,timeout;
    int search;
    static long time;
    @Override
    public void run() {
        search();
        time=System.currentTimeMillis()-timeStart;
    }
    public void search(){
        Simple<Demain> train = new SimpleArray<Demain>();
        try {
            train=constructorsForXML.read("file.xml");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        int indexSeach=0;

        for (int i =0;i<train.size();i++){
            if((System.currentTimeMillis()-timeStart)>=timeout) {
                TimeoutException e = new TimeoutException();
                e.printStackTrace();
                return;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //int n= Integer.parseInt(train.get(i).getNumberFlight());
            int n= Integer.parseInt(train.get(i).getNumberFlight());
            if(n==search){
                indexSeach=i;
            }

            if((System.currentTimeMillis()-timeStart)>=timeout) {
                TimeoutException e = new TimeoutException();
                e.printStackTrace();
                return;
            }
        }
        System.out.println("Index element : [ "+indexSeach+" ]");
        System.out.println("Time working search element : [ "+(System.currentTimeMillis()-timeStart)+"мс ]");
    }
}
