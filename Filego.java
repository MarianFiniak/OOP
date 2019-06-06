import java.io.File;
import java.util.Scanner;

public class Filego  {
    public String doFile() {
// определяем объект для каталога
        String s2 = "";
        Filego main = new Filego();
        Scanner in = new Scanner(System.in);
        String s = "E://";
        String s1;
        while (true) {
            File dir = new File(s);
            // если объект представляет каталог
            if (dir.isDirectory()) {
                // получаем все вложенные объекты в каталоге
                for (File item : dir.listFiles()) {

                    if (item.isDirectory()) {

                        System.out.println( item.getName() +  "  \t (folder)");
                    } else {

                        System.out.println( item.getName() +  "\t (file)");
                    }
                }
            }
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
                if(s2.equals(".xml")){
                    return s1;
                }
                else if (s2.equals(".out")){
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
    public String[] make_info(Simple<Demain> demains){
        String[] strings = new String[demains.size()];
        for (int i=0;i<demains.size();i++){
            strings[i] = "Назва рейсу: " +demains.get(i).getNumberFlight()+"\nДата прибуття: "+demains.get(i).getDate()+"\nКількість місць: "+demains.get(i).getNumberOfSeats()+"\n";
            System.out.println("Кількість:  .......");
            System.out.println(demains.get(i).N);
            for (int j =0;j<demains.get(i).route.size();j++){
                strings[i]+="Назва станції: "+demains.get(i).route.get(j).getNameStation()+"\n  Час приїзду: "+demains.get(i).route.get(j).getDateArrival()
                        +"\n  Час відправлення: "+demains.get(i).route.get(j).getDateDeparture()+"\n  Кількість вільнийх місць: "+demains.get(i).route.get(j).getFreeSeat()+"\n";
            }
            strings[i]+="\n";
        }
        return strings;

    }

}
