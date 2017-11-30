package br.com.flaer.dominio;
import java.io.Serializable;



	public class Cadeira implements Serializable {
	    /**
		 * 
		 */
		private static final long serialVersionUID = 6382766719805891953L;
		static Usuario[] x1 = new Usuario[100];
	    
	    
	    static void iniciaCadeiras(Usuario[] usua, Usuario[] x1){
	        Cadeira.x1 = x1;
	    }
	    
	    boolean alocaLugar(int lugar, Usuario usu){
	        
	        if(x1[lugar-1] == null){
	            usu.setPosicao(lugar);
	            Cadeira.x1[lugar-1] = usu;
	            
	        return true;
	        }
	        return false;
	    }
	    
	    static boolean desalocaLugar(int lugar){
	        if(x1[lugar-1] != null){
	            Usuario use = x1[lugar-1];
	            use.setPosicao(0);
	            x1[lugar-1] = null;
	            return true;
	        }
	        
	        return false;
	    }
	    
	    static void emptySpot(){
	        int a = 0;
	        for (int i = 0; i < x1.length; i++) {
	            if(x1[i] == null){
	                System.out.println("Cadeira "+ (i+1) + " esta vazia");
	                a++;
	            }
	           }
	        if(a==0){
	            System.out.println("Tudo Lotado");
	        }
	    }
	    
	    static void crowdedSpot(){
	        int a = 0;
	        for (int i = 0; i < x1.length; i++) {
	            if(x1[i] != null){
	                System.out.println("Cadeira "+ (i+1) + " Ocupada");
	                a++;
	            }
	           }
	        if(a==0){
	            System.out.println("Tudo livre");
	        }
	    }
	    
	    
	}
