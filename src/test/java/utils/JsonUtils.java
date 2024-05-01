package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JsonUtils {
    public static String readJsonData(String value) {
        String x = null;

        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("resources\\configs\\Test.json"));
            JSONObject jsonObject = (JSONObject) obj;
            x = (String) jsonObject.get(value);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return x;

    }
}
