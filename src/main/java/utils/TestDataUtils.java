package utils;

import com.github.javafaker.Faker;
import dto.Category;
import dto.PetDTO;
import dto.Tag;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestDataUtils {

  private static PetDTO testDataPet;

  public static PetDTO getTestDataPet() {
    return testDataPet;
  }

  public static PetDTO initialiseTestDataPet() {
    Faker faker = new Faker();
    long petId = Long.parseLong(faker.numerify("########"));

    Category category = Category.builder()
        .id(Long.parseLong("1"))
        .name("Кот")
        .build();

    Tag tag = Tag.builder()
        .id(Long.parseLong(faker.numerify("########")))
        .name("#Шерстянойзасранец")
        .build();

    testDataPet = PetDTO.builder()
        .id(petId)
        .name("Васька")
        .photoUrls(List.of("https://catphotos.ru/vasia.jpg"))
        .tags(Collections.singletonList(tag))
        .status("Домашний")
        .category(category)
        .build();

    return testDataPet;
  }
}
