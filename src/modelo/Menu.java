package modelo;
 
import java.io.Serializable;
 
public class Menu implements Serializable, Comparable<Menu> {
 
	private static final long serialVersionUID = 1L;
	private String nomeMenuBanco;
    private String nomeMenuTela;
     
    
     
    public Menu(String nomeMenuBanco, String nomeMenuTela) {
        this.nomeMenuBanco = nomeMenuBanco;
        this.nomeMenuTela = nomeMenuTela;
        
    }
 
    public String getNomeMenuBanco() {
        return nomeMenuBanco;
    }
 
    public void setNomeMenuBanco(String nomeMenuBanco) {
        this.nomeMenuBanco = nomeMenuBanco;
    }
 
    public String getNomeMenuTela() {
        return nomeMenuTela;
    }
 
    public void setNomeMenuTela(String nomeMenuTela) {
        this.nomeMenuTela = nomeMenuTela;
    }
 
    //Eclipse Generated hashCode and equals
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nomeMenuBanco == null) ? 0 : nomeMenuBanco.hashCode());
        result = prime * result + ((nomeMenuTela == null) ? 0 : nomeMenuTela.hashCode());
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Menu other = (Menu) obj;
        if (nomeMenuBanco == null) {
            if (other.nomeMenuBanco != null)
                return false;
        } else if (!nomeMenuBanco.equals(other.nomeMenuBanco))
            return false;
        if (nomeMenuTela == null) {
            if (other.nomeMenuTela != null)
                return false;
        } else if (!nomeMenuTela.equals(other.nomeMenuTela))
            return false;
        return true;
    }
 
    @Override
    public String toString() {
        return nomeMenuBanco;
    }
 
    public int compareTo(Menu document) {
        return this.getNomeMenuBanco().compareTo(document.getNomeMenuBanco());
    }
}  