package convert;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import modelo.Perfil;
import repositorio.PerfilDao;

@FacesConverter(forClass = Perfil.class, value="perfilConverter")
public class PerfilConvert implements Converter {
		
	private PerfilDao dao; // objeto de perfilDao
		
		
		@Override
		public Object getAsObject(FacesContext context, UIComponent component, String value) {
			Perfil retorno = null;
			
			if (value != null) {
				Integer id = new Integer(value);
				retorno = dao.findByCod(id);
			}
			
			return retorno;
		}

		@Override
		public String getAsString(FacesContext context, UIComponent component, Object value) {
			if (value != null) {
				return ((Perfil) value).getId().toString();
			}
			
			return "";
		}

	}


