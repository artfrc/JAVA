package com.petland.petland_api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.petland.petland_api.model.Cadastro;
import com.petland.petland_api.model.Endereco;
import com.petland.petland_api.model.Perfil;
import com.petland.petland_api.repositories.CadastroRepository;

@Component
public class StartConfig implements ApplicationRunner {

   @Autowired
   private CadastroRepository cadastroRepository;

   @Override
   public void run(ApplicationArguments args) throws Exception {
      createCadastro();
   }

   private void createCadastro() {
      Perfil perfil = new Perfil(true, false, false);
      Endereco endereco = new Endereco("Rua das Flores", "123");
      Cadastro cad = new Cadastro("Arthur", perfil, endereco);

      cadastroRepository.save(cad);
   }
}
