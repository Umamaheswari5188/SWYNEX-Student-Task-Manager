package com.example.demo;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
	    private final TaskRepository repository;

	    public TaskController(TaskRepository repository) {
	        this.repository = repository;
	    }

	    @PostMapping
	    public Task createTask(@RequestBody Task task) {
	        return repository.save(task);
	    }

	    @GetMapping
	    public List<Task> getAllTasks() {
	        return repository.findAll();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
	        return repository.findById(id)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Task> updateTask(
	            @PathVariable Long id,
	            @RequestBody Task updatedTask) {

	        return repository.findById(id).map(task -> {
	            task.setTitle(updatedTask.getTitle());
	            task.setDescription(updatedTask.getDescription());
	            task.setStatus(updatedTask.getStatus());
	            return ResponseEntity.ok(repository.save(task));
	        }).orElse(ResponseEntity.notFound().build());
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
	        if (!repository.existsById(id)) {
	            return ResponseEntity.notFound().build();
	        }

	        repository.deleteById(id);
	        return ResponseEntity.noContent().build();
	    }
	}


