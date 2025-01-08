
import io.restassured.path.json.JsonPath;
import utils.JsonUtils;

import java.util.*;
import java.io.IOException;
import java.util.Map;

public class ParsingUsingJsonPath {
    public static void main(String[] args) throws IOException {

        String filePath = "src/test/resources/complex.json";
        String jsonString = JsonUtils.convertJsonFileToString(filePath);
        /* 1.Retrieve the city of the company's location*/
        JsonPath jsonPath = new JsonPath(jsonString);
        String cityName = jsonPath.getString("company.location.city");
        System.out.println("1."+cityName);
        /* Traditional Approach*/
        /*2.Get the head of the "Engineering" department*/
        List<Map<String,Object>> departments = jsonPath.get("company.departments");
        for(Map<String,Object> department :departments)
        {
           String departmentName =  department.get("name").toString();
           if(departmentName.equalsIgnoreCase("Engineering"))
           {
               System.out.println("2.Traditional Approach:"+department.get("head").toString());
           }
        }
        /* Using JsonPath Query expression */
        /*2.Get the head of the "Engineering" department*/
        String head = jsonPath.getString("company.departments.find{it.name=='Engineering'}.head");
        System.out.println("2."+head);
        /*3.Extract the lead of the "Frontend" team.*/
        String lead = jsonPath.getString("company.departments.find{it.name=='Engineering'}.teams.find{it.name=='Frontend'}.lead");
        System.out.println("3."+lead);
        /* 4. List all skills of "Charlie." */
        List<String> skills = jsonPath.getList("company.departments.find{it.name=='Engineering'}.teams.find{it.name=='Backend'}.members.find{it.name=='Charlie'}.skills");
        System.out.println("4."+skills.toString());
    }
}
