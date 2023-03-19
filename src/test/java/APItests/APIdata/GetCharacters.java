package APItests.APIdata;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class GetCharacters {

    public static Characters getCharacters(String url){
        return   RestAssured.given()
                .when()
                .contentType(ContentType.JSON)
                .get(url)
                .then()
                .extract().as(Characters.class);

    }

}
