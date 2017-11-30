package br.com.flaer.dominio;

	import br.com.flaer.dominio.Usuario;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.io.ObjectInputStream;
	import java.io.ObjectOutputStream;
	import java.io.Serializable;
	import java.util.ArrayList;
	import java.util.logging.Level;
	import java.util.logging.Logger;


	public class Seriao implements Serializable {
	    
	   /**
		 * 
		 */
		
	private static final long serialVersionUID = 7368262418345638324L;
	public static ArrayList<Usuario> clientes = new ArrayList<>();
	   
	    public static void serializaClientes(String arquivo) {
			try {
				FileOutputStream fos = new FileOutputStream(arquivo);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(clientes);
				fos.close();
				oos.close();
			} catch (Exception e) {
				System.out.println("Erro no serializa");
				
			}
		}
		
		
		public static void loadClientes(String arquivo) {
			try {
				FileInputStream fis = new FileInputStream(arquivo);
				ObjectInputStream ois = new ObjectInputStream(fis);
				clientes = extracted(ois);
				fis.close();
				ois.close();
			} catch (Exception e) {
	                System.out.println("Não foi possivel iniciar clientes");
			}
		
		}


		@SuppressWarnings("unchecked")
		private static ArrayList<Usuario> extracted(ObjectInputStream ois) throws IOException, ClassNotFoundException {
			return (ArrayList<Usuario>) ois.readObject();
		}
	    
	    
	    
	    static void carregarLugares(String nome){
	        
	        try {
	            FileInputStream in = new FileInputStream(nome+".ser");
	            ObjectInputStream objtIn = new ObjectInputStream(in);
	            Cadeira.x1 = (br.com.flaer.dominio.Usuario[]) objtIn.readObject();
	            in.close();
	            objtIn.close();
	            
	        } catch (FileNotFoundException ex) {
	            System.out.println("Arquivo não existe");    
	        
	        }catch (IOException ex) {
	            System.out.println("Arquivo não existe"); 
	        }catch (Exception ex) {
	            System.out.println("Arquivo não existe"); 
	        }
	        
	    
	    }
	    
	    static void salvarLugares(String nome){
	        try {
	            FileOutputStream out = new FileOutputStream(nome+".ser");
	            ObjectOutputStream objtOut = new ObjectOutputStream(out);
	            objtOut.writeObject(Cadeira.x1);
	            objtOut.close();
	            out.close();
	        }catch (FileNotFoundException ex) {
	            System.out.println("Arquivo não existe"); 
	        }
	        catch (IOException ex) {
	            Logger.getLogger(Seriao.class.getName()).log(Level.SEVERE, null, ex);
	        }catch (Exception ex) {
	            Logger.getLogger(Seriao.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }
	    
	    static boolean testCpf(Usuario usu){
	        for (Usuario usuaTeste : clientes) {
	            if(usuaTeste.getCpf().equals(usu.getCpf())){
	                return true;
	            }else {
	                return false;
	            }
	        }
	        return false;
	    }
	    
	     static void cadUsuario(Usuario usuario){
	        Seriao.clientes.add(usuario);
	    }
	     static Usuario ConsulteCpf(String cpf){
	        for (Usuario usuaTeste : clientes) {
	            if(usuaTeste.getCpf().equals(cpf)){
	                return usuaTeste;
	            }else {
	                return null;
	            }
	        }
	        return null;
	    }
	   
	    
	}
	      
	    

	   


	    


