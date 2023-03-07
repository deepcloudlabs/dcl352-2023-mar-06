package com.example.hr.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import com.example.ddd.Entity;

// Entity Class -> Persistent
//                 Identity
//                 Mutable -> Business Method
//                 
// Ubiquitous Language: Employee, TcKimlikNo, FullName, Money, Iban,...
@Entity(identity = "kimlikNo", isAggregate = true)
public class Employee {
	public static final Money MIN_WAGE = new Money(8_500);
	private final TcKimlikNo kimlikNo;
	private FullName fullName;
	private Money salary;
	private Iban iban;
	private BirthYear birthYear;
	private Photo photo;
	private List<Department> departments;
	private JobStyle jobStyle;

	public Employee(Builder builder) {
		this.kimlikNo = builder.kimlikNo;
		this.fullName = builder.fullName;
		this.salary = builder.salary;
		this.iban = builder.iban;
		this.birthYear = builder.birthYear;
		this.photo = builder.photo;
		this.departments = builder.departments;
		this.jobStyle = builder.jobStyle;
	}

	public static class Builder {
		private final TcKimlikNo kimlikNo;
		private FullName fullName;
		private Money salary;
		private Iban iban;
		private BirthYear birthYear;
		private Photo photo;
		private List<Department> departments;
		private JobStyle jobStyle;

		public Builder(TcKimlikNo kimlikNo) {
			this.kimlikNo = kimlikNo;
		}

		public Builder fullName(String firstName, String lastName) {
			this.fullName = new FullName(firstName, lastName);
			return this;
		}

		public Builder salary(double value) {
			return salary(value, FiatCurrency.TL);
		}

		public Builder salary(double value, FiatCurrency currency) {
			this.salary = new Money(value, currency);
			return this;
		}

		public Builder iban(String value) {
			this.iban = Iban.of(value);
			return this;
		}

		public Builder birthYear(int value) {
			this.birthYear = new BirthYear(value);
			return this;
		}

		public Builder photo(byte[] values) {
			this.photo = Photo.of(values);
			return this;
		}

		public Builder photo(String base64EncodedValues) {
			this.photo = Photo.of(base64EncodedValues);
			return this;
		}

		public Builder jobStyle(JobStyle jobStyle) {
			Objects.requireNonNull(jobStyle);
			this.jobStyle = jobStyle;
			return this;
		}

		public Builder departments(Department... departments) {
			this.departments = new ArrayList<>(Arrays.asList(departments));
			return this;
		}

		public Builder departments(List<Department> departments) {
			this.departments = departments;
			return this;
		}

		public Employee build() {
			// policies
			if (this.departments.contains(Department.IT) && this.jobStyle.equals(JobStyle.FULL_TIME)
					&& this.salary.lessThan(MIN_WAGE.multiply(300)))
				throw new IllegalArgumentException("Salary must be larger than 4*MIN_WAGE");

			// invariants
			// business rules
			// constraint
			// validation
			return new Employee(this);
		}

	}

	public void increaseSalary(double rate) {
		// policies
		// invariants
		// business rules
		this.salary = this.salary.multiply(1.0 + rate / 100.0);
	}

	public void changeDepartment(Department from, Department to) {
		// TODO
		// policies
		// invariants
		// business rules
	}

	
	public FullName getFullName() {
		return fullName;
	}

	public void setFullName(FullName fullName) {
		this.fullName = fullName;
	}

	public Money getSalary() {
		return salary;
	}

	public void setSalary(Money salary) {
		this.salary = salary;
	}

	public Iban getIban() {
		return iban;
	}

	public void setIban(Iban iban) {
		this.iban = iban;
	}

	public BirthYear getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(BirthYear birthYear) {
		this.birthYear = birthYear;
	}

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	public JobStyle getJobStyle() {
		return jobStyle;
	}

	public void setJobStyle(JobStyle jobStyle) {
		this.jobStyle = jobStyle;
	}

	public TcKimlikNo getKimlikNo() {
		return kimlikNo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(kimlikNo);
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(kimlikNo, other.kimlikNo);
	}

	@Override
	public String toString() {
		return "Employee [kimlikNo=" + kimlikNo + ", fullName=" + fullName + ", salary=" + salary + ", iban=" + iban
				+ ", birthYear=" + birthYear + ", departments=" + departments + ", jobStyle=" + jobStyle + "]";
	}

}
