
package br.com.flaer.dominio;

public class Main {
    public static void main(String[] args) {
            Cadeira cad = new Cadeira ();
            Menu.exibeMenu();
            Menu.receberOpc(cad);
        }
}
