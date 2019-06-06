import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Max extends Thread{
    ConstructorsForXML constructorsForXML=new ConstructorsForXML();
    int max=0;
    long timeStart, timeout;
    static long time;
    @Override
    public void run() {
        max();
        time = System.currentTimeMillis()-timeStart;
    }
    public void max(){

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

        for (int i =0;i<train.size()-1;i++){
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
            int n= Integer.parseInt(train.get(i).getNumberFlight());
            int n1= Integer.parseInt(train.get(i+1).getNumberFlight());
            if(n>n1){
                max=n;
            }
            else {
                max=n1;
            }
            if((System.currentTimeMillis()-timeStart)>=timeout) {
                TimeoutException e = new TimeoutException();
                e.printStackTrace();
                return;
            }
        }

        System.out.println("Maximum : [ " + max+ " ]");
        System.out.println("Time working maximum : [ "+(System.currentTimeMillis()-timeStart)+"мс ]");
    }

}
