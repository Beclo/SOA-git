package fr.insa.mas.studentInfoService.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.mas.studentInfoService.model.StudentInfo;

@RestController
@RequestMapping("/student")
public class StudentInfoResource {
	
	@GetMapping("/{idStudent}")
	public StudentInfo getInfoEtudiant(@PathVariable("idStudent")int id) {
		List<StudentInfo> etudInfos=Arrays.asList(
				new StudentInfo(0, "Yvan", "Desfrites", "06/06/06"),
				new StudentInfo(1, "Pat", "Atra", "07/07/07"), 
				new StudentInfo(2, "Inès", "Pérait", "08/08/08"), 
				new StudentInfo(3, "Sarah", "Fréchy", "09/09/09")
		);
		System.out.println("Called!!!!");
		return etudInfos.get(id);
	}

}
