import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class FileGo {
    public String doFile() {

        String s2 = "";
        FileGo main = new FileGo();
        Scanner in = new Scanner(System.in);
        String s = "D://";
        String s1;
        while (true) {
            File dir = new File(s);




            s1 = in.nextLine();
            if(s1.equals("..")){
                char[] c = s.toCharArray();
                for (int i =c.length-3;i>-1;i--){
                    System.out.print(c[i]);
                    if (c[i] =='/') {
                      int k =i+1;
                      s="";
                      for (int j =0;j<k;j++){
                          s+=c[j];
                      }
                      i=-1;
                    }
                }
            }
            else {
                char[]c =s1.toCharArray();
                for (int i =c.length-4;i<c.length;i++){
                    s2+=c[i];
                }
                if(s2.equals(".txt")){
                    return s1;
                }
                else {
                    s += s1 + "//";
                }
                s2="";
            }
            System.out.println();
            System.out.println(s);
        }

    }
    public String[] make_info(ArrayList<Demain> demains){
        String[] strings = new String[demains.size()];
        for (int i=0;i<demains.size();i++){
            strings[i] = "Назва рейсу: " +demains.get(i).getNumberFlight()+"\nДата прибуття: "+demains.get(i).getDate()+"\nКількість місць: "+demains.get(i).getNumberOfSeats()+"\n";
            for (int j =0;j<demains.get(i).route.size();j++){
                strings[i]+="Назва станції: "+demains.get(i).route.get(j).getNameStation()+"\n  Час приїзду: "+demains.get(i).route.get(j).getDateArrival()
                        +"\n  Час відправлення: "+demains.get(i).route.get(j).getDateDeparture()+"\n  Кількість вільнийх місць: "+demains.get(i).route.get(j).getFreeSeat()+"\n";
            }
            strings[i]+="\n";
        }
        return strings;

    }

}
