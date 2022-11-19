package data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BillData {
    public String Name,Address,City,State,Zip,Phone,Account, Amount;

    public void BillData() throws IOException, ParseException {
        String src = System.getProperty("user.dir")+"/src/test/java/data/BillData.json";
        File file = new File(src);

        JSONParser parser = new JSONParser();
        JSONArray JArray = (JSONArray) parser.parse(new FileReader(file));

        for (Object JsonObj : JArray){
            JSONObject person = (JSONObject) JsonObj;

            Name = (String) person.get("name");
            Address = (String) person.get("address");
            City = (String) person.get("city");
            State = (String) person.get("state");
            Zip = (String) person.get("zip");
            Phone =(String) person.get("phone");
            Account = (String) person.get("account");
            Amount = (String) person.get("amount");
        }
    }
}
