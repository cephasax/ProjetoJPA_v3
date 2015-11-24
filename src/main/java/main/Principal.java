package main;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.Banco;
import dao.GenericDAO;
import model.Carro;
import model.Contato;
import model.Motor;

public class Principal {

	
	
	/*
	 
	Crie uma estrutura de banco de dados que permita guardar todas as ações que são efetuadas sobre as entidades de sua aplicação.
	Requesitos Básicos:
	1. Configurar um projeto com Maven;
	2. Criar no mínimo 2 entidades (Entity);
	3. Utilizar o GenericDAO para chamar as rotinas de manipulação de dados, assim como as logging;
	4. Criar uma Entidade LogDatabase e persistir informações baseadas nas alterações do banco 
		de dados utilizando o EmptyInterceptor, configurando o hibernate.ejb.interceptor;
	5. Criar uma classe principal que persista informações iniciais no projeto, com intuito de validar 
		o logging.
	6. Compacte seu projeto e submeta pelo SIGAA.
	
	*/
	public static void main(String[] args) {
		
		Calendar data = Calendar.getInstance();
		GenericDAO gdao = new GenericDAO();
		
		//Inserir objetos no banco
		
		Contato c1 = new Contato();
        c1.setNome("Cephas Alves Barreto!!!!");
        c1.setTelefone("8888-4444");
		c1.setDataNascimento(data.getTime());
		gdao.inserir(c1);
		
		Contato c2 = new Contato();
        c2.setNome("Jose nome antigo!!!!");
        c2.setTelefone("8888-5555");
		c2.setDataNascimento(data.getTime());
		gdao.inserir(c2);
		
		Carro carro1 = new Carro();
		carro1.setModelo("Astra");
		carro1.setDataFabricacao(data.getTime());
		carro1.setApelido("Astral");
		
		Carro carro2 = new Carro();
		carro2.setModelo("Celta");
		carro2.setDataFabricacao(data.getTime());
		carro2.setApelido("Ceu ta preto");
		
		Motor m1 = new Motor();
		m1.setNumeroSerie("15490342-w-34");
		m1.setPotenciaCavalos(200);
		m1.setQtdCilindros(4);
		
		Motor m2 = new Motor();
		m2.setNumeroSerie("2004005-x-82");
		m2.setPotenciaCavalos(142);
		m2.setQtdCilindros(3);
		
		m1.setCarro(carro1);
		carro1.setMotor(m1);
		gdao.inserir(carro1);
		gdao.inserir(m1);
		
		m2.setCarro(carro2);
		carro2.setMotor(m2);
		gdao.inserir(carro2);
		gdao.inserir(m2);
		
		
		//deletar
		
		Contato cDeletado = new Contato();
        cDeletado.setNome("teste!!!!");
        
        Motor mDeletado = new Motor();
        mDeletado.setNumeroSerie("teste");
                
        Carro carroDeletado = new Carro();
        carroDeletado.setApelido("apelido teste");
        
        gdao.inserir(cDeletado);
        gdao.inserir(mDeletado);
        gdao.inserir(carroDeletado);

        gdao.excluir(cDeletado);
        gdao.excluir(mDeletado);
        gdao.excluir(carroDeletado);
        
        
		
		//update
		
		Contato cUpdate = new Contato();
		Carro carroUpdate = new Carro();
		Motor mUpdate = new Motor();
		
		cUpdate = (Contato) gdao.findById(Contato.class, (long)11);
		carroUpdate = (Carro) gdao.findById(Carro.class, (long)41);
		mUpdate = (Motor) gdao.findById(Motor.class, (long)51);
		
		cUpdate.setNome("Novo nome");
		carroUpdate.setApelido("novo apelido");
		mUpdate.setNumeroSerie("novo numero de serie");
		
		gdao.atualizar(cUpdate);
		gdao.atualizar(carroUpdate);
		gdao.atualizar(mUpdate);
	}

}
