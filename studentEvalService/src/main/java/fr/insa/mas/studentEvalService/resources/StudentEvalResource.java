package fr.insa.mas.studentEvalService.resources;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.mas.studentEvalService.model.Evaluation;

import java.util.Arrays;

@RestController
@RequestMapping("/evaluation")
public class StudentEvalResource {
	
	@GetMapping("/{idStudent}")
	public Evaluation getStudentEval(@PathVariable("idStudent") int idEtud) {
		List<Evaluation> evalList = Arrays.asList(
				new Evaluation(0, 13F), 
				new Evaluation(1, 10.5F), 
				new Evaluation(2, 18F), 
				new Evaluation(3, 18F)
		);
		
		return evalList.get(idEtud);
	}

}
