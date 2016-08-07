package insert;

import modelo.Perfil;
import repositorio.PerfilDao;

public class InseriPerfil {
	public static void main(String[] args) {
		
		Perfil p = new  Perfil();
		PerfilDao pd = new PerfilDao();
		
		
		try {
			p.setId(1);
			p.setDescricao("ADMINISTRADOR");
			System.out.println("Dados Gravados");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
