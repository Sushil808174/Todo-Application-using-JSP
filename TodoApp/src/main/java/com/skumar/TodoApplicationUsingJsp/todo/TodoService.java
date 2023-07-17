package com.skumar.TodoApplicationUsingJsp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {

	public static int count = 0;
	public static List<Todo> todos = new ArrayList<>();
	static {
		todos.add(new Todo(++count,"Susheel","Learn AWS",LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++count,"Himanshu","Spring framework",LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++count,"Aman","Spring Boot",LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++count,"Ratan","Spring Security",LocalDate.now().plusYears(1),false));
	}
	
	public List<Todo> findByUsername(String username){
		
		Predicate<Todo> predicate = todo->todo.getUserName().equalsIgnoreCase(username);
		
		return todos.stream().filter(predicate).toList();
	}
	
	public void addNewTodo(String username,String desc,LocalDate targetDate,boolean isDone) {
	
		Todo todo = new Todo(++count, username, desc, targetDate, isDone);
		todos.add(todo);
	}
	
	public void deleteById(int id) {
		Predicate<Todo> predicate = todo->todo.getId()==id;
		
		todos.removeIf(predicate);
	}

	public Todo findById(int id) {
		Predicate<Todo> predicate = todo->todo.getId()==id;
		
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodoMethod(@Valid Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
		
	}
}
