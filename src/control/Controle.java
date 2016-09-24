package control;

import modelo.Nota;


public class Controle {

	public static void calcMedia(Nota n){		
	   n.setMedia(  (n.getNota1() + n.getNota2() + n.getNota3() + n.getNota4() )/4 );
		if(n.getMedia()<5){
			n.setSituacao("Reprovado");
		}else if(n.getMedia()<7){
			n.setSituacao("Recuperacao");
	    }else{
		    n.setSituacao("Aprovado");
	
	    }
}
		
	
	
}
