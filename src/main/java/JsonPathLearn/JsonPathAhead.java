package JsonPathLearn;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;

public class JsonPathAhead {

	public static void main(String[] args) {

//		JsonPath path = SerenityRest.rest().baseUri("https://jiraUrl")
//				.given()
//				.header("Authorization", "Basic ffgsdfg=")
//				.basePath("/jira/rest/agile/1.0/")
//				.when()
//				.get("/issue/bugID")
//				.jsonPath();

		String bugID = "BugID";
		try {
			String responseBody = HttpClientBuilder.create().setDefaultHeaders(new ArrayList<Header>() {
				{
					add(new BasicHeader("Authorization", "Basic authentication"));
				}
			})
					.build()
					.execute(new HttpGet("https://jiraURL"+"/jira/rest/agile/1.0/issue/"+bugID),
							httpResponse -> {
								HttpEntity entity = httpResponse.getEntity();
								return entity != null ? EntityUtils.toString(entity) : null;
							});

			String bugStatus = com.jayway.jsonpath.JsonPath.parse(responseBody).read("fields.status.name");
//			new io.restassured.path.json.JsonPath(responseBody).getString("fields.status.name");
			if (bugStatus.equalsIgnoreCase("Closed"))
				System.err.println(bugID + " <-- FAILED!!! Status Is : "+bugStatus);
			else System.out.println(bugID + " <-- Success. Status Is : "+bugStatus);

		} catch (IOException e) {
			System.out.println("Exception While Executing API " + e.getMessage());
		}

//		JsonPath path = SerenityRest.rest().when().given().get("issue/bugID").jsonPath();

//		Map<Object, Object> m = (Map<Object, Object>) path.getMap("$").get("fields");
//		System.out.println(((Map<Object, Object>) m.get("status")).get("name"));

//		System.out.println(path.getString("fields.status.name"));
	}
}
