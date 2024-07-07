package extensions;

import static utils.TestDataUtils.initialiseTestDataPet;

import dto.PetDTO;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import services.PetService;

public class CreatePetExtension implements BeforeEachCallback {

  @Override
  public void beforeEach(ExtensionContext extensionContext) throws Exception {
    PetDTO pet = initialiseTestDataPet();
    new PetService()
        .createNewPet(pet)
        .statusCode(200);
  }
}
