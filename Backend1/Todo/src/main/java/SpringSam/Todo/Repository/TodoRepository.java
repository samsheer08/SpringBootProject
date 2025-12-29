package SpringSam.Todo.Repository;


import SpringSam.Todo.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo ,Long> {

}
