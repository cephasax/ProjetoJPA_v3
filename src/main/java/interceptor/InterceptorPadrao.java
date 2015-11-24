package interceptor;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import model.Carro;
import model.Contato;
import model.LogDatabase;
import model.Motor;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import dao.GenericDAO;

public class InterceptorPadrao extends EmptyInterceptor{

	private static final long serialVersionUID = 1L;
	private String tipoOperacao;
	
	private Set<Contato> contatosSalvos = new HashSet<Contato>();
	private Set<Carro> carrosSalvos = new HashSet<Carro>();
	private Set<Motor> motoresSalvos = new HashSet<Motor>();
	
	private Set<Contato> contatosExcluidos = new HashSet<Contato>();
	private Set<Carro> carrosExcluidos = new HashSet<Carro>();
	private Set<Motor> motoresExcluidos = new HashSet<Motor>();
	
	private Set<Contato> contatosAtualizados = new HashSet<Contato>();
	private Set<Carro> carrosAtualizados = new HashSet<Carro>();
	private Set<Motor> motoresAtualizados = new HashSet<Motor>();
	
	GenericDAO gdao = new GenericDAO();
	
	public boolean onSave(Object entity, Serializable id, Object[] state,
		String[] propertyNames, Type[] types){
		
		if (entity instanceof Contato) {
			Contato ent = (Contato) entity;
			contatosSalvos.add(ent);
		}
		
		if (entity instanceof Carro) {
			Carro ent = (Carro) entity;
			carrosSalvos.add(ent);
		}
		
		if (entity instanceof Motor) {
			Motor ent = (Motor) entity;
			motoresSalvos.add(ent);
		}
		
		tipoOperacao = "Save";
		
		return super.onSave(entity, id, state, propertyNames, types);
	}
	
	public void onDelete(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types){
			
			if (entity instanceof Contato) {
				Contato ent = (Contato) entity;
				contatosExcluidos.add(ent);
			}
			
			if (entity instanceof Carro) {
				Carro ent = (Carro) entity;
				carrosExcluidos.add(ent);
			}
			
			if (entity instanceof Motor) {
				Motor ent = (Motor) entity;
				motoresExcluidos.add(ent);
			}
			
			tipoOperacao = "Delete";
			super.onDelete(entity, id, state, propertyNames, types);
	}
	
	public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, 
            Object[] previousState, String[] propertyNames, Type[] types) {
        if (entity instanceof Contato) {
        	Contato ent = (Contato) entity;
        	contatosAtualizados.add(ent);
        	tipoOperacao = "Update";
        	return true;
        }
        
        if (entity instanceof Contato) {
        	Carro ent = (Carro) entity;
        	carrosAtualizados.add(ent);
        	tipoOperacao = "Update";
        	return true;
        }
        
        if (entity instanceof Motor) {
        	Motor ent = (Motor) entity;
        	motoresAtualizados.add(ent);
        	tipoOperacao = "Update";
        	return true;
        }
        
        return false;
    }
	
	@Override
    public void postFlush(@SuppressWarnings("rawtypes") Iterator entities) {        
        super.postFlush(entities);
        
        try{
        	
        
        //Contato
	        for (Contato cont : contatosSalvos) {
	        	LogDatabase log = new LogDatabase();
	        	log.setEntidade(cont.getClass().getCanonicalName());
	    		log.setTipoOperacao(tipoOperacao);
	    		log.setValorAlterado(cont.getId().toString());
	    		log.setDataAlteracao(new Date());
	    		gdao.inserirLog(log);
	        }
	        
	        for (Contato cont : contatosExcluidos) {
	        	LogDatabase log = new LogDatabase();
	        	log.setEntidade(cont.getClass().getCanonicalName());
	    		log.setTipoOperacao(tipoOperacao);
	    		log.setValorAlterado(cont.getId().toString());
	    		log.setDataAlteracao(new Date());
	    		gdao.inserirLog(log);
	        }
	        
	        for (Contato cont : contatosAtualizados) {
	        	LogDatabase log = new LogDatabase();
	        	log.setEntidade(cont.getClass().getCanonicalName());
	    		log.setTipoOperacao(tipoOperacao);
	    		log.setValorAlterado(cont.getId().toString());
	    		log.setDataAlteracao(new Date());
	    		gdao.inserirLog(log);
	        }
	        
	        //Carro
	        for (Carro cont : carrosSalvos) {
	        	LogDatabase log = new LogDatabase();
	        	log.setEntidade(cont.getClass().getCanonicalName());
	    		log.setTipoOperacao(tipoOperacao);
	    		log.setValorAlterado(cont.getId().toString());
	    		log.setDataAlteracao(new Date());
	    		gdao.inserirLog(log);
	        }
	        
	        for (Carro cont : carrosExcluidos) {
	        	LogDatabase log = new LogDatabase();
	        	log.setEntidade(cont.getClass().getCanonicalName());
	    		log.setTipoOperacao(tipoOperacao);
	    		log.setValorAlterado(cont.getId().toString());
	    		log.setDataAlteracao(new Date());
	    		gdao.inserirLog(log);
	        }
	        
	        for (Carro cont : carrosAtualizados) {
	        	LogDatabase log = new LogDatabase();
	        	log.setEntidade(cont.getClass().getCanonicalName());
	    		log.setTipoOperacao(tipoOperacao);
	    		log.setValorAlterado(cont.getId().toString());
	    		log.setDataAlteracao(new Date());
	    		gdao.inserirLog(log);
	        }
	        
	        //Motor
	        for (Motor cont : motoresSalvos) {
	        	LogDatabase log = new LogDatabase();
	        	log.setEntidade(cont.getClass().getCanonicalName());
	    		log.setTipoOperacao(tipoOperacao);
	    		log.setValorAlterado(cont.getId().toString());
	    		log.setDataAlteracao(new Date());
	    		gdao.inserirLog(log);
	        }
	        
	        for (Motor cont : motoresExcluidos) {
	        	LogDatabase log = new LogDatabase();
	        	log.setEntidade(cont.getClass().getCanonicalName());
	    		log.setTipoOperacao(tipoOperacao);
	    		log.setValorAlterado(cont.getId().toString());
	    		log.setDataAlteracao(new Date());
	    		gdao.inserirLog(log);
	        }
	        
	        for (Motor cont : motoresAtualizados) {
	        	LogDatabase log = new LogDatabase();
	        	log.setEntidade(cont.getClass().getCanonicalName());
	    		log.setTipoOperacao(tipoOperacao);
	    		log.setValorAlterado(cont.getId().toString());
	    		log.setDataAlteracao(new Date());
	    		gdao.inserirLog(log);
	        }
        }
        finally{
        	contatosSalvos.clear();
        	carrosSalvos.clear();
        	motoresSalvos.clear();
        	
        	contatosExcluidos.clear();
        	carrosExcluidos.clear();
        	motoresExcluidos.clear();
        	
        	contatosAtualizados.clear();
        	carrosAtualizados.clear();
        	motoresAtualizados.clear();
        }
        
	}    

}
