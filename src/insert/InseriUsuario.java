package insert;

import repositorio.PerfilDao;
import repositorio.UsuarioDao;
import modelo.Perfil;
import modelo.Usuario;

public class InseriUsuario {
	public static void main(String[] args) {
		
		Usuario usuario = new Usuario();
		UsuarioDao dao = new UsuarioDao();
		Perfil   p = new Perfil(null, "administrador");
		PerfilDao pd = new PerfilDao();
		
		try {			
			usuario.setId(null);
			usuario.setLogin("LEOALVES");
			usuario.setSenha("LEJOBA");
			usuario.setPerfil(p);
			pd.create(p);
			
					
			dao.create(usuario);
			System.out.println("Dados gravados");
				
						
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
