package dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PetDTO {

  private Category category;
  private Long id;
  private String name;
  private List<String> photoUrls;
  private String status;
  private List<Tag> tags;
}
