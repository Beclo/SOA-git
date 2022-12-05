package fr.insa.mas.studentListService.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import fr.insa.mas.studentListService.model.*;

@RestController
@RequestMapping("/students")
public class StudentListResource {
	
	@Autowired
	private RestTemplate restTemplate; 
	
	@GetMapping("ids/{idSpeciality}")
	public StudentIDList getIDStudents(@PathVariable("idSpeciality") String speciality) {
		
		StudentIDList studentsId=new StudentIDList();
		studentsId.addStudentToList(0);
		studentsId.addStudentToList(1);
		studentsId.addStudentToList(2);
		studentsId.addStudentToList(3);
		
		return studentsId;
	}
	
	@GetMapping("/all/{idSpeciality}")
	public List<Student> getStudents(@PathVariable("idSpeciality") String speciality) {
		
		StudentIDList studentsId=new StudentIDList();
		studentsId.addStudentToList(0);
		studentsId.addStudentToList(1);
		studentsId.addStudentToList(2);
		studentsId.addStudentToList(3);
		
		int i=0; 
		List<Student> listStudents = new ArrayList<Student>();
		
		while(i<studentsId.getStudentList().size()) {
			StudentInfo etudInfos = restTemplate.getForObject("http://studentInfoService/student/"+i, StudentInfo.class);
			Evaluation eval=restTemplate.getForObject("http://studentEvalService/evaluation/" + i, Evaluation.class);
			listStudents.add(new Student(i, etudInfos.getFirstName(), etudInfos.getLastName(), eval.getAverage()));
			i++; 
		}
		return listStudents;
	}

}
