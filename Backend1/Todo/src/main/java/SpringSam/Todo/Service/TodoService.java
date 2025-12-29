package SpringSam.Todo.Service;

import SpringSam.Todo.Repository.TodoRepository;
import SpringSam.Todo.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;
    public Todo createTodo(Todo todo){
        return todoRepository.save(todo);
    }
    public Todo getTodoById(Long id){
        return todoRepository.findById(id).orElseThrow(()->new RuntimeException("Todo not found"));
    }
    public Page<Todo> getAllTodosPages(int page , int size){
        PageRequest pageable = PageRequest.of(page, size);
        return todoRepository.findAll(pageable);


    }
    public List<Todo> getTodos(){
        return todoRepository.findAll();
    }
    public Todo updateTodo(Todo todo){
        return todoRepository.save(todo);
    }
    public void deleteById(Long id){
        todoRepository.deleteById(id);
    }
}
