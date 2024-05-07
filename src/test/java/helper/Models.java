package helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import static helper.Utility.generateRandomEmail;

public class Models {
    private static RequestSpecification request;
    public static void setupHeaders(){
        request = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer 740a5c185a0ef8f7de2900e106d92fb03affdca318e3d7c924ebfd025ba4eb52");
    }

    public static Response getListUsers(String endpoint){
        setupHeaders();
        return request.when().get(endpoint);
    }
    public static Response postCreateUser(String endpoint){
        String name = "Mala Yoichi";
        String gender ="female";
        String email = generateRandomEmail();
        String status ="active";
        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("gender", gender);
        payload.put("email", email);
        payload.put("status", status);

        setupHeaders();
        return request.body(payload.toString()).when().post(endpoint);
    }

    public static Response deleteUser(String endpoint, String user_Id){
        setupHeaders();
        String finalEndpoint = endpoint + "/" +user_Id;
        return request.when().get(endpoint);
    }

    public static Response updateUser(String endpoint, String user_Id){
        setupHeaders();

        String name = "Mala Edit";
        String gender ="female";
        String email = generateRandomEmail();
        String status ="active";
        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("gender", gender);
        payload.put("email", email);
        payload.put("status", status);

        String finalEndpoint = endpoint + "/" +user_Id;
        return request.body(payload.toString()).when().patch(finalEndpoint);
    }
}
