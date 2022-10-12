import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
 @JsonPropertyOrder({"name","code"})
public class Assignment4 {

    public String country,code;


    public static void main(String[] args) throws IOException {

        String file =  new String(Files.readAllBytes(Paths.get(".\\jason\\countries.json"))) ;
        System.out.println(file);


    }
}
