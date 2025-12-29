package SpringSam.Todo.Controller;

import SpringSam.Todo.Service.TodoService;
import SpringSam.Todo.models.Todo;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/todo")
public class TodoController {
    @Autowired
    private TodoService todoService ;
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "Todo retrieved successfully") ,
            @ApiResponse(responseCode = "404" , description = "Todo not found")
    })
    @GetMapping("/{id}")
    ResponseEntity<Todo> getTodoById(@PathVariable Long id)
    {
       try{
           Todo gotId = todoService.getTodoById(id);
           return new ResponseEntity<>(gotId , HttpStatus.OK) ;

       }
       catch(RuntimeException exception){
           log.error("", exception);
           return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
       }
    }
    @GetMapping("/Page")
    ResponseEntity<Page<Todo>> getTodoPaged(@RequestParam int page , @RequestParam int size){
        return new ResponseEntity<>(todoService.getAllTodosPages(page, size) , HttpStatus.OK);
    }
    @PostMapping("/create")
    ResponseEntity<Todo>  createdId(@RequestBody Todo todo){
        return new ResponseEntity<>(todoService.createTodo(todo),HttpStatus.CREATED);
    }
    @GetMapping
    ResponseEntity<List<Todo>> getTodos(){
        return new ResponseEntity<>(todoService.getTodos() , HttpStatus.OK);
    }
    @PutMapping
    ResponseEntity<Todo> updateTodo(@RequestBody Todo todo){
        return new ResponseEntity<>(todoService.updateTodo(todo) , HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/{id}")
    void deleteById(@PathVariable long id){
        todoService.deleteById(id);
    }


}
