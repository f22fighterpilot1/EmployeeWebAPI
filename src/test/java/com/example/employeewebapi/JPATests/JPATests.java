package com.example.employeewebapi.JPATests;
import static org.assertj.core.api.Assertions.assertThat;
import com.example.employeewebapi.Model.Employee;
import com.example.employeewebapi.Repository.EmployeeRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;



@DataJpaTest
class JPATests {

	@Autowired
	EmployeeRepo employeeRepo;

	@Test
	public void should_find_no_employees_if_repository_is_empty() {
		Iterable employees = employeeRepo.findAll();

		assertThat(employees).isEmpty();
	}

	@Test
	public void test_create_product() {
		Employee emp = new Employee();
		emp.setFIRSTNAME("firstNameTest");
		Employee employee = employeeRepo.save(emp);

		assertThat(employee.getEMPLOYEEID()).isGreaterThan(0);

	}




}
