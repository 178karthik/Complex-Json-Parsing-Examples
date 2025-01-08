import com.fasterxml.jackson.databind.JsonNode;
import utils.JsonUtils;

import java.io.IOException;

public class ParsingUsingJsonNode {
    public static void main(String[] args) throws IOException {


        String filePath = "src/test/resources/complex.json";
        JsonNode jsonNode = JsonUtils.readJsonFile(filePath);
        /* 1.Retrieve the city of the company's location*/
        String cityName = jsonNode.get("company").get("location").get("city").asText();
        System.out.println("1."+cityName);
        /*2.Get the head of the "Engineering" department*/
        JsonNode departments =  jsonNode.get("company").get("departments");
        for(JsonNode department:departments)
        {
           String departmentName = department.get("name").asText();
           if(departmentName.equalsIgnoreCase("Engineering"))
           {
               System.out.println("2."+department.get("head").asText());
           }
        }
        /*3.Extract the lead of the "Frontend" team.*/
        for(JsonNode department:departments)
        {
            JsonNode teams = department.get("teams");
            for(JsonNode team :teams)
            {
                String teamName = team.get("name").asText();
                if(teamName.equalsIgnoreCase("Frontend"))
                {
                    System.out.println("3."+team.get("lead").asText());
                }
            }
        }
        /* 4. List all skills of "Charlie." */
        for(JsonNode department :departments)
        {
            JsonNode teams = department.get("teams");
            for(JsonNode team :teams)
            {
               JsonNode members = team.get("members");
               for(JsonNode member :members)
               {
                   String memberName = member.get("name").asText();
                   if(memberName.equalsIgnoreCase("Charlie"))
                   {
                       JsonNode skills = member.get("skills");
                       for(JsonNode skill :skills)
                       {
                           System.out.println("4."+skill.asText());
                       }
                   }
               }
            }
        }

    }
}
