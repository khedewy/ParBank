package data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class RegisterData {
    public String firstName, lastName, address, city, state, zip, ssn, phone, userName,password;

    public void UserData() throws IOException, ParseException {
        String srcFile = System.getProperty("user.dir")+"/src/test/java/data/RegisterData.json";
        File file = new File(srcFile);

        JSONParser parser = new JSONParser();
        JSONArray JArray = (JSONArray) parser.parse(new FileReader(file));

        for (Object jsonObj : JArray){
            JSONObject person = (JSONObject) jsonObj;

            firstName = (String) person.get("firstName");
            lastName = (String) person.get("lastName");
            address = (String) person.get("address");
            city = (String) person.get("city");
            state = (String) person.get("state");
            zip = (String) person.get("zip");
            ssn = (String) person.get("ssn");
            phone = (String) person.get("phone");
            userName = (String) person.get("userName");
            password = (String) person.get("password");
        }
    }
}
