import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String FILENAME="file1.txt";
        System.out.println("Записати(1) чи переглянути(2) інформацію?");
        String s4=in.nextLine();
        ArrayList<Demain> train = new ArrayList<Demain>();
        if (s4.equals("1")) {
            System.out.println("Введіть кількість маршрутів: ");
            int M = in.nextInt();


            for (int k = 0; k < M; k++) {
                Demain demain = new Demain();
                train.add(demain);

            }
            System.out.println("Зберегти файл?(так/ні):");
            in.nextLine();
            String s3 = in.nextLine();
            if (s3.equals("так")) {
                System.out.println("Ви хочете вибрати файл?(так/ні):");
                s3 = in.nextLine();
                FileGo file = new FileGo();
                if (s3.equals("так")) {
                    FILENAME = file.doFile();
                }
                Save save=new Save();
                save.save(train,M,FILENAME);

            }
        }
        if (s4.equals("2")) {
            System.out.println("Ви хочете вибрати файл?(так/ні):");
            String s3 = in.nextLine();
            FileGo file = new FileGo();
            if (s3.equals("так")) {
                FILENAME = file.doFile();
            }
            Save sava = new Save();
            train = sava.resave(FILENAME);
            String[] strings;
            FileGo make_info=new FileGo();
            strings = make_info.make_info(train);
            for (int i = 0;i<train.size();i++)
                System.out.print(strings[i]);
        }

    }
}






