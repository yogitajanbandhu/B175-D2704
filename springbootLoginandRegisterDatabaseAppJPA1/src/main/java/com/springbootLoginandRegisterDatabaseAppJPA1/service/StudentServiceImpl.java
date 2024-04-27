package com.springbootLoginandRegisterDatabaseAppJPA1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.springbootLoginandRegisterDatabaseAppJPA1.model.Student;
import com.springbootLoginandRegisterDatabaseAppJPA1.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
public class StudentServiceImpl implements StudentServiceI {

	@Autowired
	StudentRepository sr;
	
	@Override
	public void saveData(Student s) {
		 sr.save(s);
		
	}

	@Override
	public List<Student> loginStudent(String username, String password) {
		
		if(username.equals("admin") && password.equals("admin"))
		{
			//return (List<Student>) sr.findAll();            //this is for predefined method findAll()
			return (List<Student>) sr.fetchAllStudentData();  // this is for JPQL passed thru repository.both are same
		}
		else
		{
			//return sr.findByUsernameAndPassword(username, password);    //this is for custom finder method.
			return sr.findbyusernameandpassword(username, password);      // this is for JPQL passed thru repository.both are same 
		}
	}

	@Transactional
	@Modifying
	@Override
	public List<Student> deleteStudent(int rollno) {
	
		sr.deleteById(rollno);
		
		return (List<Student>) sr.findAll();
	}

	
	@Override
	public Student editStudent(int rollno) {
		
		Optional<Student> os =sr.findById(rollno);
		
		if(os.isPresent())
		{
			   Student s= os.get();
			   return s;
		}
		else
		{
			return null;
		}
	}
	
	
	@Override
	public List<Student> updateStudent(Student s) {
	           sr.save(s);
		return (List<Student>) sr.findAll();
	}

	@Override
	public List<Student> paging(int pageNo, int size) {
	
		
		Pageable p=PageRequest.of(pageNo, size, Sort.by("rollno").descending());
		return sr.findAll(p).getContent();
	}
    
	
}
