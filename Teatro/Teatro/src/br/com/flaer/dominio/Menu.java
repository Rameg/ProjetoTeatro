package br.com.flaer.dominio;

import java.util.Scanner;

import br.com.flaer.dominio.Cadeira;	
import br.com.flaer.dominio.Usuario;


/**
 * @author LETSAP
 *
 */
public class Menu {

	private static final Scanner SCANNER = new Scanner(System.in);



	/**
	 * 
	 */
	public Menu() {				
		
	}
	
	static void exibeMenu() {
		System.out.println("##################### #");
	       System.out.println("1 Cadastrar Usuario");
	       System.out.println("2 Consultar Usuario");
	       System.out.println("3 Ocupar lugar");
	       System.out.println("4 Desocupar lugar");
	       System.out.println("5 Exibir lugares vazios");
	       System.out.println("6 Exibir lugares ocupados");
	       System.out.println("7 Encerrar programa.");
		System.out.println("################### ##   #");
	}
	

	
	static void receberOpc(Cadeira cadeir){
	       try {
	              int opc = SCANNER.nextInt();
	       int opc2;
	       
	       
	       switch(opc){
	            case 1:
	                Usuario usa = new Usuario();
	                Scanner scnU = SCANNER;
	                System.out.println("Digite um nome ");
	                usa.setNome(scnU.nextLine());
	                System.out.println("Digite o cpf: ");
	                usa.setCpf(scnU.nextLine());
	                if(!Seriao.testCpf(usa)){
	                    Seriao.cadUsuario(usa);
	                    System.out.println("Usuario cadastrado");
	                }else{
	                    System.out.println("Cpf ja existente");
	                    
	                }
	                break;
	                
	             case 2: 
	                 System.out.println("Digite seu cpf: ");
	                 Scanner scnC = SCANNER;
	                    Usuario usaC = Seriao.ConsulteCpf(scnC.nextLine());
	                    if(usaC != null){
	                        System.out.println("Nome: "+ usaC.getNome());
	                        System.out.println("Cpf: "+ usaC.getCpf());
	                        System.out.println("Localizacao: " + usaC.getPosicao());
	                    }else{
	                        System.out.println("Usuario inexistente");
	                    }
	                 break;
	             case 3:
	                 System.out.println("Digite o cpf");
	                 Scanner recC = SCANNER;
	                 Usuario UsuCad = Seriao.ConsulteCpf(recC.nextLine());
	                 if(UsuCad != null){
	                     System.out.println("Digite o numero para marcar cadeira");
	                
	                
	                 try {
	                     opc2 = SCANNER.nextInt();
	                     
	                     if(!cadeir.alocaLugar(opc2, UsuCad)){
	                     UsuCad.setPosicao(opc2);
	                    System.out.println("Lugar marcado");
	                }else {
	                    System.out.println("Cadeira indisponiel");
	                }
	                 } catch (Exception e) {
	                     System.out.println("Cadeira ocupada");
	                 }
	                 }else{
	                     System.out.println("Usuario inexistente");
	                 }
	                
	                break;
	            case 4:
	                System.out.println("Digite o numero da cadeira que deseja desocupar");
	                
	              
	                try {
	                    opc2 = SCANNER.nextInt();
	                    if(!!Cadeira.desalocaLugar(opc2)){
	                    System.out.println("Cadeira liberada");
	                }else{
	                    System.out.println("Cadeira vazia");
	                }
	                } catch (Exception e) {
	                    System.out.println("Cadeira ocupada");
	                }
	                break;
	            case 5:
	                ;
	                Cadeira.emptySpot();
	                break;
	            case 6:
	                
	                Cadeira.crowdedSpot();
	                break;
	                
	                case 7:
	                    System.out.println("Deseja salvar?");
	                    Scanner bra2 = SCANNER;
	                String rec = bra2.nextLine();
	                if(rec.equals("S")){
	                    System.out.println("Digite o arquivo");
	                    String nomeArq = bra2.nextLine();
	                    Seriao.serializaClientes(nomeArq);
	                    Seriao.salvarLugares(nomeArq);
	       }
	                System.exit(0);
	                break;
	           
	            default:
	                 System.out.println("Opcao invalida");
	    }
	   
	} catch (Exception e) {
	           System.out.println("Opcao invalida");
	       }

	   
	}
	}

