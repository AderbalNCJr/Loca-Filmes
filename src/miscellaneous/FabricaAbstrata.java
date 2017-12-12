package miscellaneous;

import Controller.Controller;
import Model.Model;
import View.View;

/**
 * @author Higor Alves
 */
public abstract class FabricaAbstrata {
    public abstract View criarView();
    public abstract Model criarModelo();
    public abstract Controller criarControle();
    
    public static FabricaAbstrata getFabrica(String fabrica){
        if (fabrica.equalsIgnoreCase("cliente")){
            return new ClienteFabrica();
        }else if (fabrica.equalsIgnoreCase("filme")){
            return null;
        }else if(fabrica.equalsIgnoreCase("locacao")){
            return null;
        }else {
            return null;
        }
    }
}