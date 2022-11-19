package data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UpdateProfileInformationData {

    public String firstName, lastName, Address, City,state, zip, phone;

    public void UpdateData() throws IOException, ParseException {
        String src = System.getProperty("user.dir")+"/src/test/java/data/UpdateData.json";
        File file = new File(src);

        JSONParser parser = new JSONParser();
        JSONArray JArray = (JSONArray) parser.parse(new FileReader(file));

        for (Object JSonObject : JArray){
            JSONObject person = (JSONObject) JSonObject;

            firstName = (String) person.get("firstName");
            lastName = (String) person.get("lastName");
            Address = (String) person.get("address");
            City = (String) person.get("city");
            state = (String) person.get("state");
            zip = (String) person.get("zip");
            phone = (String)  person.get("phone");
        }
    }
}
