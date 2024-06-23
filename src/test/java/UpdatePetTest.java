import dto.PetDTO;
import dto.PetResponseDTO;
import extensions.CreatePetExtension;
import extensions.DeletePetExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import services.PetService;

import java.util.ArrayList;

import static utils.TestDataUtils.getTestDataPet;

@ExtendWith({CreatePetExtension.class, DeletePetExtension.class})
public class UpdatePetTest {

    private PetDTO pet = getTestDataPet();

    private PetService petService = new PetService();

    /**
     * Проверка изменения запросом put значения поля name
     */
    @Test
    public void updatePetName() {
        String newPetName = "Барсик";
        pet.setName(newPetName);

        PetResponseDTO petResponse = petService.updatePet(pet)
                .statusCode(200)
                .extract().body().as(PetResponseDTO.class);

        Assertions.assertEquals(pet.getId(), petResponse.getId());
        Assertions.assertEquals(newPetName, petResponse.getName());
    }

    /**
     * Проверка изменения запросом put значения поля tags
     * Изначально в массиве tags находится один объект
     * В запросе put отправляется пустой массив tags
     */
    @Test
    public void updatePetTags() {
        pet.setTags(new ArrayList<>());

        PetResponseDTO petResponse = petService.updatePet(pet)
                .statusCode(200)
                .extract().body().as(PetResponseDTO.class);

        Assertions.assertEquals(pet.getId(), petResponse.getId());
        Assertions.assertEquals(0, petResponse.getTags().size());
    }
}
