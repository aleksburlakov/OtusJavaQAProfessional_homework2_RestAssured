package services;

import static io.restassured.RestAssured.given;

import dto.PetDTO;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PetService {

  private static final String BASE_URI = System.getProperty("base.url");
  private static final String PET_BASE_PATH = "pet";
  private final RequestSpecification requestSpecification;

  public PetService() {
    requestSpecification = given()
        .baseUri(BASE_URI)
        .basePath(PET_BASE_PATH)
        .contentType(ContentType.JSON);
  }

  public ValidatableResponse createNewPet(PetDTO pet) {
    return given()
        .spec(requestSpecification)
        .body(pet)
        .log().all()
        .when()
        .post()
        .then()
        .log().all();
  }

  public ValidatableResponse updatePet(PetDTO pet) {
    return given()
        .spec(requestSpecification)
        .body(pet)
        .log().all()
        .when()
        .put()
        .then()
        .log().all();
  }

  public ValidatableResponse deletePet(long id) {
    return given()
        .spec(requestSpecification)
        .basePath(PET_BASE_PATH + "/" + id)
        .log().all()
        .when()
        .delete()
        .then()
        .log().all();
  }
}
