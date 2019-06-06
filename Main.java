import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.*;
import java.util.Scanner;

public class Main {
    //static int i = 0;
    public static void main(String[] args) throws IOException, TransformerException, ParserConfigurationException, SAXException, ClassNotFoundException {
        ConstructorsForXML constructorsForXML = new ConstructorsForXML();
        Scanner in = new Scanner(System.in);
        String FILENAME = "file1.xml";
        String s4 ;

        Simple<Demain> train = new SimpleArray<>();

        Filego file = new Filego();
        String s3;
        int M=0;

        if (args.length > 0) {
            if (args[0].equals("-auto")) {
                train = constructorsForXML.read("file.xml");
                String[] strings = file.make_info(train);
                for (String s : strings) {
                    System.out.println(s);
                }
            }
        } else {
            do {
                System.out.println("*Записати нову інформацію (1)\n" +
                        "*Добавити інформацію (2) \n" +
                        "*Переглянути (3)\n" +
                        "*Зберегти (4)\n" +
                        "*Видалити (5)\n" +
                        "*Вийти (6)");
                System.out.print("Ваша команда : ");
                s4 = in.nextLine();
                System.out.println();
                if (s4.equals("1")) {
                    System.out.println("Введіть кількість маршрутів: ");
                    M = in.nextInt();
                    for (int k = 0; k < M; k++) {
                        Demain demain = new Demain();
                        train.add(demain);

                    }

                }
                if (s4.equals("2")) {
                    System.out.println("Ви хочете вибрати файл, куди добавити інформації?(Т/Н):");
                    s3 = in.nextLine();
                    if (s3.equals("Т")) {
                        FILENAME = file.doFile();
                    }
                    train.clear();
                    train = constructorsForXML.read(FILENAME);

                    System.out.println("Введіть кількість маршрутів: ");
                    int K = in.nextInt();


                    for (int k = 0; k < K; k++) {
                        Demain demain = new Demain();
                        train.add(demain);
                        M++;
                    }
                }
                if (s4.equals("3")) {

                    System.out.println("Ви хочете вибрати файл, звідки будете дивитися інформацію?(Т/Н):");
                    s3 = in.nextLine();

                    if (s3.equals("Т")) {
                        FILENAME = file.doFile();
                    }
                    System.out.print("Дивитися з файлу .xml чи .out(1/2): ");
                    s3=in.nextLine();
                    Simple<Demain> train2 = new SimpleArray<>();
                    if(s3.equals("1")) {
                        train2.clear();
                        train2 = constructorsForXML.read(FILENAME);
                    }
                    else {
                        FileInputStream fis = new FileInputStream("temp.out");
                        ObjectInputStream oin = new ObjectInputStream(fis);
                        train2 = (Simple<Demain>) oin.readObject();
                    }
                   // System.out.println(train2.get(0).getNumberFlight());
                    String[] strings = file.make_info(train2);
                    for (String s : strings) {
                        System.out.println(s);
                    }
                    //System.out.println(train2.size());

                }
                if (s4.equals("4")) {
                        System.out.println("Ви хочете вибрати файл?(Т/Н):");
                        s3 = in.nextLine();
                        if (s3.equals("Т")) {
                            FILENAME = file.doFile();
                        }
                    System.out.print("Зберегти в .xml чи .out файл?(1/2): ");
                        s3=in.nextLine();
                        if (s3.equals("1")) {
                            constructorsForXML.WriteParamXML(train, FILENAME);
                        }
                        else {
                            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("temp.out"));
                            oos.writeObject(train);
                            oos.flush();
                            oos.close();
                        }
                }
                if (s4.equals("5")) {
                    System.out.print("Видалити інформацію з файлу чи з контейнера?(ф/к): ");
                    s3 = in.nextLine();
                    if (s3.equals("ф")) {
                        System.out.println("Ви хочете вибрати файл?(Т/Н):");
                        s3 = in.nextLine();
                        if (s3.equals("Т")) {
                            FILENAME = file.doFile();
                        }
                        System.out.print("Файл .xml чи .out?(1/2): ");
                        s3=in.nextLine();
                        if (s3.equals("1")) {
                            train = constructorsForXML.read(FILENAME);
                        }
                        else {
                            FileInputStream fis = new FileInputStream("temp.out");
                            ObjectInputStream oin = new ObjectInputStream(fis);
                            train = (Simple<Demain>) oin.readObject();
                        }
                    }
                    System.out.println("Видалити всю інформацію?(Т/Н): ");
                    s3 = in.nextLine();
                    if (s3.equals("Т")) {
                        train.clear();
                        M=0;
                    } else {
                        System.out.print("Введіть індекс елемента який ви хочете видалити: ");
                        int i = in.nextInt();
                        train.delete(i);
                        M--;
                    }
                }

            } while (!s4.equals("6"));
        }
    }
}






