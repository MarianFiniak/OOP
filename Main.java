
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static long MILLIS_TO_WAIT = 0,startTime,timeParal,timePosl;
    private static int numberF;
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, TransformerException {
        String FILENAME="file.xml";
        ConstructorsForXML constructorsForXML=new ConstructorsForXML();
        String s ="";
        Scanner in = new Scanner(System.in);
        Simple<Demain> train = new SimpleArray();

        Max max = new Max();
        Minimum miminum = new Minimum();
        Search search = new Search();


        do {
        System.out.println("Зчитати з файлу [файл]\n" +
                "Записати нові дані [нові]\n" +
                "Дописати нові дані [дописати]\n" +
                "Згенерерувати дані [згенерувати]\n" +
                "Пройти до наступного етапу [наступний]\n" +
                "Вийти [вийти]");
            switch (in.nextLine()) {
                case ("файл"):
                    train = constructorsForXML.read(FILENAME);
                    break;
                case ("нові"):
                    System.out.println("Введіть кількість маршрутів: ");
                    int M = in.nextInt();
                    in.nextLine();
                    train.clear();
                    for (int k = 0; k < M; k++) {
                        Demain demain = new Demain("");
                        train.add(demain);

                    }
                    constructorsForXML.WriteParamXML(train, FILENAME);
                    break;
                case ("дописати"):
                    train = constructorsForXML.read(FILENAME);

                    System.out.println("Введіть кількість маршрутів: ");
                    int K = in.nextInt();
                    for (int k = 0; k < K; k++) {
                        Demain demain = new Demain("");
                        train.add(demain);
                    }
                    constructorsForXML.WriteParamXML(train, FILENAME);
                    break;
                case ("згенерувати"):
                    System.out.println("Введіть кількість маршрутів: ");
                    M = in.nextInt();
                    in.nextLine();
                    for (int k = 0; k < M; k++) {
                        Demain demain = new Demain();
                        train.add(demain);
                    }
                    constructorsForXML.WriteParamXML(train, FILENAME);
                    break;
                case ("наступний"):
                    s = "наступний";
                    break;
                case ("вийти"):
                    return;
            }
        }while (s.equals("наступний")==false);

        System.out.println("Паралельне чи послідовна обробка інформації(1/2) :");
       do {
           switch (in.nextLine()) {
               case ("1"):
                   System.out.println("Введіть максимальний час виконання:");
                   MILLIS_TO_WAIT = (long) (in.nextDouble() * 1000);
                   in.nextLine();
                   startTime = System.currentTimeMillis();
                   System.out.println("Введіть назву маршрута для пошуку його індекса");
                   numberF = in.nextInt();
                   startTime = System.currentTimeMillis();
                   doexample();
                   timeParal = System.currentTimeMillis() - startTime;

                   break;
               case ("2"):
                   System.out.println("Введіть максимальний час виконання:");
                   MILLIS_TO_WAIT = (long) (in.nextDouble() * 1000);
                   in.nextLine();
                   startTime = System.currentTimeMillis();

                   max.timeStart = startTime;
                   max.timeout = MILLIS_TO_WAIT;
                   miminum.timeStart = startTime;
                   miminum.timeout = MILLIS_TO_WAIT;
                   search.timeStart=startTime;
                   search.timeout=MILLIS_TO_WAIT;
                   search.search=numberF;
                   max.max();
                   miminum.min();
                   search.search();
                   timePosl = System.currentTimeMillis() - startTime;
                   System.out.println("Time : [ " + timePosl + " ] ");
                   break;
               case ("3"):
                   timeParal= search.time;
                   System.out.println("Time paralelno : " + timeParal);
                   System.out.println("Time poslidovno: " + timePosl);
                   double c = (double)timePosl/timeParal;
                   String С = String.format("%.2f", c);
                   System.out.println("Difference     : " + С );
                   break;
               case ("вихід"):
                   s="вихід";
                   break;

           }
       }while (s.equals("вихід")==false);


            //long estimatedTime = System.currentTimeMillis() - startTime;

            //System.out.println(estimatedTime);

        }
        static void doexample()
        {
            Max max = new Max();
            Minimum miminum = new Minimum();
            Search search = new Search();
            max.timeStart=startTime;
            max.timeout=MILLIS_TO_WAIT;
            miminum.timeStart=startTime;
            miminum.timeout=MILLIS_TO_WAIT;
            search.timeStart=startTime;
            search.timeout=MILLIS_TO_WAIT;
            search.search=numberF;
            max.start();
            miminum.start();
            search.start();
        }


    }


