import java.io.FileNotFoundException; 
import java.io.PrintWriter; 
import java.util.LinkedHashMap; 
import java.util.Map; 
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
import org.json.simple.parser.*;  
import java.io.FileReader;

public class JSONExample 
{ 
    public static void main(String[] args) throws FileNotFoundException  
    {
    	JSONObject jo = new JSONObject();
        jo.put("Name", "Stu");
        jo.put("state", "CA");

        JSONArray ja = new JSONArray();

        Map m = new LinkedHashMap(2);
        m.put("email", "caoshuxun@gmail.com");
        m.put("phone", "281-285-1818");
        ja.add(m);
        jo.put("contact", ja);

        PrintWriter pw = new PrintWriter("JSONExample1.json");
        pw.write(jo.toJSONString());

        pw.flush();
        pw.close();

        try {
            Object obj = new JSONParser().parse(new FileReader("JSONExample1.json"));
            JSONObject jr = (JSONObject) obj;
            String name = (String)jr.get("Name");
            System.out.println(name);
        } catch(Exception e) {
            System.out.println("file not found");
        }
        

    }
}
