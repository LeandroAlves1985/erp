package insert;

import repositorio.UsuarioDao;
import modelo.Usuario;

public class InseriUsuario {
	public static void main(String[] args) {
		
		Usuario usuario = new Usuario();
		UsuarioDao dao = new UsuarioDao();
		
		usuario.setId(null);
		usuario.setLogin("leandro");
		usuario.setSenha("leandro");
		
		dao.create(usuario);
		System.out.println("Dados gravados");
	}

}
