package APIdata;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

public class GetCharacters {

    public static Characters getCharacters(String url){
        return   given()
                .when()
                .contentType(ContentType.JSON)
                .get(url)
                .then()
                .extract().as(Characters.class);

    }

}
