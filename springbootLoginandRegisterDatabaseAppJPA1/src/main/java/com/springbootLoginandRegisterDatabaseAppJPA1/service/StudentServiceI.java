package com.springbootLoginandRegisterDatabaseAppJPA1.service;

import java.util.List;

import com.springbootLoginandRegisterDatabaseAppJPA1.model.Student;

public interface StudentServiceI {

	public void saveData(Student s);

	public List<Student> loginStudent(String username, String password);

	

	public Student editStudent(int rollno);


	public List<Student> updateStudent(Student s);

	public List<Student> paging(int pageNo, int i);

	public List<Student> deleteStudent(int rollno);



	

}
