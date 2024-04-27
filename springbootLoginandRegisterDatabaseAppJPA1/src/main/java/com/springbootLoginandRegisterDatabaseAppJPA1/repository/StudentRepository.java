package com.springbootLoginandRegisterDatabaseAppJPA1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.springbootLoginandRegisterDatabaseAppJPA1.model.*;

import jakarta.transaction.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>

{
	//custom finder method. below method will create query to fetch data from table
	//base on username and password
     public List<Student> findByUsernameAndPassword(String username,String password);
     
     
     public void deleteById(int rollno);  //delete from student where name=?;
     
     //JPQL==HQL and SQL for that we use @Query annotation
     
     //JPQl
     //fetchAllData using JPQL
     @Query(value=" from Student")
     public List<Student> fetchAllStudentData();  
     //check in StudentServiceImpl , I have commented predefined method and used 
     //JPQL in method -->   loginStudent(String username, String password)
     
     
     //fetch data based on username and password
     @Query(value="from Student where username=?1 and password=?2")
     public List<Student> findbyusernameandpassword(String username,String password);
     //here username=?1 and password=?2"  --> 1 is position of username that is first position
     // 2 is second position in method calling
     
     @Transactional
     @Modifying
     @Query(value="update Student set name=?1, username=?2,password=?3 where rollno=?4")
     public Student updateStudent(String name, String username, String password, int rollno);
     
}






//HERE We have used JpaRepository not CrudRepository as we are performing paging and sorting
//along with crud operation
//JpaRepository is child class of Crud and paging/sorting
//it will inherits all the crud and paging/sorting methods