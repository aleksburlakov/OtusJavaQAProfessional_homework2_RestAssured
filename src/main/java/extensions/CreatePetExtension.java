package extensions;

import dto.Category;
import dto.PetDTO;
import dto.PetResponseDTO;
import dto.Tag;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import services.PetService;

import java.util.Arrays;

import static utils.TestDataUtils.initialiseTestDataPet;

public class CreatePetExtension implements BeforeEachCallback {

    @Override
    public void beforeEach(ExtensionContext extensionContext) throws Exception {
        PetDTO pet = initialiseTestDataPet();
        new PetService()
                .createNewPet(pet)
                .statusCode(200);
    }
}
