package SpringSam.Todo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;




@Data
@Entity
public class Todo {
    @Id
    @GeneratedValue
    long id;
    @NotBlank
    @NotNull
    String title;
    Boolean isCompleted;
}
