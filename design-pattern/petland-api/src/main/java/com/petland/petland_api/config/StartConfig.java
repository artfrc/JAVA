package com.petland.petland_api.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.petland.petland_api.model.ProdutoServico;
import com.petland.petland_api.repositories.ProdutoServicoRepository;

@Component
public class StartConfig implements ApplicationRunner {

   @Autowired
   private ProdutoServicoRepository produtoServicoRepository;

   @Override
   public void run(ApplicationArguments args) throws Exception {
      createCadastro();
   }

   private void createCadastro() {
      ProdutoServico produtoServico = new ProdutoServico();
      produtoServico.setNome("Banho e Tosa");
      produtoServico.setServico(true);
      produtoServico.setValor(50.0);

      produtoServicoRepository.save(produtoServico);
   }
}
