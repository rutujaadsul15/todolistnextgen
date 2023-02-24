package com.todo.todolistnextgen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TodolistnextgenApplication {
	public static void main(String[] args) {
		System.out.println("App started");
		SpringApplication.run(TodolistnextgenApplication.class, args);
	}

}
