package com.br.artfc.cursos.useCases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.artfc.cursos.dto.CursoResponseGetDTO;
import com.br.artfc.cursos.repositories.CursoRepository;

@Service
public class ListCursoUseCase {
   
   @Autowired
   private CursoRepository cursoRepository;

   public Map<String, Object> execute() {
      var courses = this.cursoRepository.findAll();
      ArrayList<CursoResponseGetDTO> coursesDTO = new ArrayList<>();
      courses.forEach(course -> {
         coursesDTO.add(new CursoResponseGetDTO(course.getId(), course.getName(), course.getCategory(), course.getActive(), course.getCreatedAt()));
      });
      Map<String, Object> response = new HashMap<>();
      response.put("size", coursesDTO.size());
      response.put("type", "course");
      response.put("courses", coursesDTO);
      return response;
   }
}
