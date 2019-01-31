package com.demo.oop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.bean.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeTest {
	@Test
	public void employeeTest() {
		// fill the staff array with three Employee objects
		Employee[] staff = new Employee[3];

		staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
		staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
		staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);

		// raise everyone's salary by 5%
		for (Employee e : staff)
			e.raiseSalary(5);

		// print out information about all Employee objects
		for (Employee e : staff) {

		}
	}
	
    @Test
    public void testByValueOrByRefer() {
    	Employee a = new Employee("Alice",  75000, 1987, 12, 15);
    	Employee b = new Employee("Bob", 50000, 1989, 10, 1);
    	swap(a, b);
    	System.out.println(a);
    }

	private void swap(Employee x, Employee y) {
		// TODO Auto-generated method stub
		Employee temp = x;
		x = y;
		y = temp;
	}
	
}
