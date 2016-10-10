package com.algaworks.venda.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.algaworks.venda.model.Categoria;
import com.algaworks.venda.repository.Categorias;
import com.algaworks.venda.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Categoria.class)
public class CategoriaConverter implements Converter{

	//@Inject -> Inject não funciona em converter!
	private Categorias categorias;
	
	public CategoriaConverter(){
		categorias = CDIServiceLocator.getBean(Categorias.class); //CDIServiceLocator é uma alternativa para CDI em converter
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Categoria retorno = null;
		
		if(value != null){
			Long id = new Long(value);
			retorno = categorias.porId(id);
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null){
			return ((Categoria)value).getId().toString();
		}
		
		return "";
	}

}
