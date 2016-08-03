package insert;

import repositorio.UsuarioDao;
import modelo.Usuario;

public class InseriUsuario {
	public static void main(String[] args) {
		
		Usuario usuario = new Usuario();
		UsuarioDao dao = new UsuarioDao();
		
		try {
			usuario.setId(null);
			usuario.setLogin("Teste01");
			usuario.setSenha("Teste01");
			
			if(! (dao.findByLogin(usuario.getLogin()) == null)){
				System.out.println("Ja existe");
			}else{
				dao.create(usuario);
				System.out.println("Dados gravados");
				
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
