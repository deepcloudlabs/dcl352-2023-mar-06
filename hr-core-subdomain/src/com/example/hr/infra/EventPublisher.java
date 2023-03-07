package com.example.hr.infra;

public interface EventPublisher<E> {

	void emit(E event);

}
