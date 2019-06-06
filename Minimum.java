import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Minimum extends Thread{
        long timeStart,timeout;
        static long time;
        ConstructorsForXML constructorsForXML=new ConstructorsForXML();
        int min=0;
        @Override
        public void run() {
            min();
            time=System.currentTimeMillis()-timeStart;
        }
        public void min(){
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
                if(n<n1){
                    min=n;
                }
                else {
                    min=n1;
                }
                if((System.currentTimeMillis()-timeStart)>=timeout) {
                    TimeoutException e = new TimeoutException();
                    e.printStackTrace();
                    return;
                }
            }
            System.out.println("Minimum : [ "+min+" ]");
            System.out.println("Time working minimum : [ "+(System.currentTimeMillis()-timeStart)+"мс ]");
        }

    }
