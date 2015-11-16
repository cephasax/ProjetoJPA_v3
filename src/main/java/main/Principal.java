package main;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.Banco;
import dao.GenericDAO;
import model.Contato;

public class Principal {

	public static void main(String[] args) {
		
		Calendar data = Calendar.getInstance();
		GenericDAO gdao = new GenericDAO();
		
		Contato c = new Contato();
        c.setNome("Cephas Barreto!!!!");
        c.setTelefone("8888-4444");
        c.setDataNascimento(data.getTime());
        c.setId((long)200);
        gdao.inserir(c);
        
      /*  c = (Contato) gdao.findById(c.getClass(), (long)70);
		gdao.excluir(c);*/
	}

}
