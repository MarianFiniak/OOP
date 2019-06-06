import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RedEx {
    public String time(String s){
        Pattern pattern = Pattern.compile("^(([1]{1}[0-9])|([2]{1}[0-3]{1})|([0-9]{1})):([0-5]{1}[0-9]{1})$");
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()){
            return s;
        }
        else {
            return "Error";
        }
    }

    public String station(String s){
        Pattern pattern = Pattern.compile("^[а-я]{1,21}$");
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()){
            return s;
        }
        else {
            return "Error";
        }
    }
    public String seat(String s){
        Pattern pattern = Pattern.compile("^[0-9]{1,4}$");
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()){
            return s;
        }
        else {
            return "Error";
        }
    }
    public String date(String s){
        Pattern pattern = Pattern.compile("^(([0-2]{1}[0-9]{1})|([3]{1}[0-1]{1})).(([0]{1}[1-9]{1})|([1]{1}[0-2]{1})).[2]{1}[0]{1}(([1]{1}[8-9]{1})|([2]{1}[0]{1}))$");
        Matcher matcher = pattern.matcher(s);
        if(matcher.find()){
            return s;
        }
        else {
            return "Error";
        }

    }
    public String nameF(String s){
        Pattern pattern = Pattern.compile("^[0-9]{5}$");
        Matcher matcher = pattern.matcher(s);
        if(matcher.matches()){
            return s;
        }
        else {
            return "Error";
        }

    }
}
