
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Assignment4 {

 static Scanner get = new Scanner(System.in);
 static Map<String,String> file = new HashMap<>();
    public static void main(String[] args) throws IOException {

      ObjectMapper objectMapper = new ObjectMapper();
      File jsonFile = new File(".\\jason\\countries.json");
      List<Country> countries = objectMapper.readValue(jsonFile, new TypeReference<List<Country>>() {});
      countries.forEach(obj1 -> map(obj1.getName(), obj1.getCode()));


        System.out.println("Enter whether you want to find the country name or by using country code \n 1 for Find using country code \n 2 Find using Country name");
        int i = get.nextInt();

        if (i==1) {
            System.out.println("Enter the country name \n");
            usingCountryName(get.next().toUpperCase());
        } else if (i==2) {
            usingCountryCode(get.next().toUpperCase());
        }else {
            System.out.println("Enter the country code \n");
            System.out.println("Entered wrong in put ");
        }

    }
       public static void map(String name, String code){
               file.put(name.toUpperCase(),code.toUpperCase());
       }
    public static void usingCountryName(String name){
        String a = file.get(name);
        if (a == null){
            System.out.println("Invalid input");
        }else {
            System.out.println(a);
        }
        get.close();
    }


    public static void usingCountryCode(String code){
        String a = getKey(file, code);
        if (a == null){
            System.out.println("Invalid input");
        }else {
            System.out.println(a);
        }
        get.close();
    }
    public static <K, V> K getKey(Map<K, V> map, V value)
    {
        for (Map.Entry<K, V> entry: map.entrySet())
        {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
}
