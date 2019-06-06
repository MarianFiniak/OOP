package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  throws IOException, ClassNotFoundException {
        Scanner in = new Scanner(System.in);

        Cont<String> i = new Cont<String>();
        String vidpovid;
        String s2,what_you_do;
        boolean w = true;
        do {
            System.out.println("New information  - 1\n" +
                    "Edit            - 2\n" +
                    "Enter new element- 3\n"+
                    "Delete inform    - 4\n"+
                    "Viev             - 5\n"+
                    "Exit             - 6");
            System.out.println("Enter comand: ");
            what_you_do = in.nextLine();
            if (what_you_do.equals("1")) {
                do {
                    System.out.println("Enter new date:");
                    s2 = in.nextLine();
                    i.add(s2);
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("temp.out"));
                    oos.writeObject(i);
                    oos.flush();
                    oos.close();
                    System.out.println("End enter date?(Y/N)");
                    what_you_do=in.nextLine();
                }while (what_you_do.equals("Y"));

            } else if (what_you_do.equals("2")) {

                FileInputStream fis = new FileInputStream("temp.out");
                ObjectInputStream oin = new ObjectInputStream(fis);
                Cont ts = (Cont) oin.readObject();

                System.out.println("What information you want edit(enter index): ");
                int index = in.nextInt();
                System.out.println();
                System.out.println("Information:    " + ts.set(index - 1));
                System.out.println("You want chang this info: ");
                in.nextLine();
                vidpovid = in.nextLine();
                if (vidpovid.equals("Yes") || vidpovid.equals("Y")) {
                        System.out.println("Edit text: ");
                        vidpovid = in.nextLine();
                        ts.add(index-1,vidpovid);
                        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("temp.out"));
                        oos.writeObject(ts);
                        oos.flush();
                        oos.close();
                    }
                }



            if(what_you_do.equals("3")){
                FileInputStream fis = new FileInputStream("temp.out");
                ObjectInputStream oin = new ObjectInputStream(fis);
                Cont ts = (Cont) oin.readObject();
                System.out.println("Enter information, what you want add: ");
                String new_element = in.nextLine();
                ts.add(new_element);
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("temp.out"));
                oos.writeObject(ts);
                oos.flush();
                oos.close();
            }
            if (what_you_do.equals("4")){
                FileInputStream fis = new FileInputStream("temp.out");
                ObjectInputStream oin = new ObjectInputStream(fis);
                Cont ts = (Cont) oin.readObject();
                System.out.println("You want delet all information(Y/N):");
                String vid =in.nextLine();
                if(vid.equals("Y")){
                    ts.clear();
                }
                else {
                    System.out.println("You know index or element(i/e):");
                    vid = in.nextLine();
                    if (vid.equals("i")){
                        System.out.println("Enter index: ");
                        int index = in.nextInt();
                        ts.remove(index-1);
                    }
                    if(vid.equals("e")){
                        System.out.println("Enter element:");
                        vid=in.nextLine();
                        ts.remove(vid);
                    }
                }
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("temp.out"));
                oos.writeObject(ts);
                oos.flush();
                oos.close();
            }
            if(what_you_do.equals("5")){
                FileInputStream fis = new FileInputStream("temp.out");
                ObjectInputStream oin = new ObjectInputStream(fis);
                Cont<String> ts = (Cont<String>) oin.readObject();

                for (Object s: ts) System.out.println(s);

                System.out.println();
            }

        }while (!what_you_do.equals("6"));
    }

}





