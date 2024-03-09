package in.ashokit.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.ashokit.binding.Student;
import in.ashokit.entity.StudentEntity;
import in.ashokit.repository.StudentRepository;

@Controller
public class StudentController {
	
	
	@Autowired
	private StudentRepository repo;
	
	
	//method to load the form
			@GetMapping("/")
			public String loadForm(Model model) {
				loadFormData(model);
				
				return "index";
				
			}
			
			
	private void loadFormData(Model model) {
		List<String> coursesList =new ArrayList<>();
		coursesList.add("Java");
		coursesList.add("DevOps");
		coursesList.add("AWS");
		coursesList.add("Python");
		
		List<String> timingsList=new ArrayList<>();
		timingsList.add("Morning");
		timingsList.add("Afternoon");
		timingsList.add("Evening");

		
		Student student =new Student();
		model.addAttribute("courses", coursesList);
		model.addAttribute("timings", timingsList);
		model.addAttribute("student",student);
	}
	
	//method to save student Data
		
		@PostMapping("/save")
		public String handleSubmit(Student s, Model model) {
			
			//logic to save
			model.addAttribute("msg", "Student Saved");
			
			StudentEntity entity=new StudentEntity();
			
			//Copy student data from binding obj to entity obj
			BeanUtils.copyProperties(s, entity);
			
			entity.setTimings(Arrays.toString(s.getTimings()));
			
			repo.save(entity);
			
			loadFormData(model);
			
			return "index";
			
		}
		
		//method to display saved data
		
		@GetMapping("/viewStudents")
		public String getStudentsData(Model model) {
			
			//logic to fetch and send students data 
			
			List <StudentEntity> studentsList = repo.findAll();
			model.addAttribute("students", studentsList);
			return "data";
		}
}
