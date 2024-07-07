package extensions;

import static utils.TestDataUtils.getTestDataPet;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import services.PetService;

public class DeletePetExtension implements AfterEachCallback {
  @Override
  public void afterEach(ExtensionContext extensionContext) throws Exception {
    new PetService().deletePet(getTestDataPet().getId());
  }
}
