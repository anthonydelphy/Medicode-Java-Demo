import com.google.gson.Gson;

import javax.print.Doc;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.IOException;


public class main{

    public static void main(String[] args){
        Database db = new Database();
        String content = "";
        try {
            content = readFile("database.json", StandardCharsets.UTF_8);
        }
        catch(IOException e){};
        Gson gson = new Gson();
        db = gson.fromJson(content, Database.class);


        System.out.println(db.getPatient(0).getPrescription(0).toString());
    }

    static String readFile(String path, Charset encoding)
            throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
}