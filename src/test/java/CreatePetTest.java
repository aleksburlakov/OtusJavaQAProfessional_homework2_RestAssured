import static utils.TestDataUtils.initialiseTestDataPet;

import dto.PetDTO;
import dto.PetResponseDTO;
import extensions.DeletePetExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import services.PetService;

@ExtendWith({DeletePetExtension.class})
public class CreatePetTest {

  private final PetService petService = new PetService();
  private final PetDTO pet = initialiseTestDataPet();

  /**
   * Проверка создания сущности с незаполненными полями в запросе
   */
  @Test
  public void createPetWithEmptyFieldsTest() {
    PetDTO emptyPet = new PetDTO();

    PetResponseDTO petResponse = petService.createNewPet(emptyPet)
        .statusCode(200)
        .extract().body().as(PetResponseDTO.class);

    long petId = petResponse.getId();
    Assertions.assertNotNull(petResponse.getId());
    Assertions.assertNull(petResponse.getName());
    Assertions.assertNull(petResponse.getStatus());
    Assertions.assertNull(petResponse.getCategory());
    Assertions.assertEquals(0, petResponse.getPhotoUrls().size());
    Assertions.assertEquals(0, petResponse.getTags().size());

    pet.setId(petId);
  }

  /**
   * Проверка создания сущности со всеми заполненными полями в запросе
   */
  @Test
  public void createPetWithAllFilledFieldsTest() {
    PetResponseDTO petResponse = petService.createNewPet(pet)
        .statusCode(200)
        .extract().body().as(PetResponseDTO.class);

    Assertions.assertEquals(pet.getId(), petResponse.getId());
    Assertions.assertEquals(pet.getName(), petResponse.getName());
    Assertions.assertEquals(pet.getStatus(), petResponse.getStatus());
    Assertions.assertEquals(pet.getCategory(), petResponse.getCategory());
    Assertions.assertEquals(pet.getPhotoUrls(), petResponse.getPhotoUrls());
    Assertions.assertEquals(pet.getTags(), petResponse.getTags());
  }
}
