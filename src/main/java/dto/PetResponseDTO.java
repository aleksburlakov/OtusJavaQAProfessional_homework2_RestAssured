package dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PetResponseDTO {
  private long id;
  private Category category;
  private String name;
  private List<String> photoUrls;
  private List<Tag> tags;
  private String status;
}
