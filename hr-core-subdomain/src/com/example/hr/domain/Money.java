package com.example.hr.domain;

import java.util.Objects;

import com.example.ddd.ValueObject;

@ValueObject
public record Money(double value, FiatCurrency currency) {
	public Money(double value) {
		this(value, FiatCurrency.TL);
	}

	public Money(double value, FiatCurrency currency) {
		if (value <= 0.0)
			throw new IllegalArgumentException("Money value must be poisitive.");
		Objects.requireNonNull(currency);
		this.value = value;
		this.currency = currency;
	}

	public Money multiply(double factor) {
		return new Money(this.value * factor, this.currency);
	}

	public boolean lessThan(Money other) {
		return this.value < other.value;
	}
}
