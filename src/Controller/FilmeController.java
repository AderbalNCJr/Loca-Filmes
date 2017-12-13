package Controller;

import Model.Cliente;
import Model.Filme;
import java.util.List;
import miscellaneous.Database;
import miscellaneous.FabricaAbstrata;

/**
 * @author Higor Alves
 */
public class FilmeController implements Controller{
     private Filme filme;
    
    public boolean addRow(String titulo, int faixaEtaria){
        try{
            if (titulo.equals("")){
                return false;
            }else{
                filme = (Filme)FabricaAbstrata.getFabrica("filme").criarModelo();
                filme.setId(Database.getInstancia().getFilmeId());
                filme.setNome(titulo);
                filme.setFaixaEtaria(faixaEtaria);
                filme.setAlugado(false);
            
                if (Database.getInstancia().addData(filme)){
                    Database.getInstancia().setFilmeId(1);
                }else {
                    return false;
                }
           }
        }catch(NumberFormatException e){
            return false;
        }
        return true;
    }
    public boolean removerRow(int id){
        Database.getInstancia().removeDataF(id);
        return true;
    }
    public boolean alterarRow(int id, String titulo, int faixaEtaria,boolean alugado, String newTitulo, int newFaixaEtaria){
        filme = (Filme) FabricaAbstrata.getFabrica("filme").criarModelo();
        filme.setId(id);
        filme.setNome(titulo);
        filme.setFaixaEtaria(faixaEtaria);
        filme.setAlugado(false);
        
        if (Database.getInstancia().FeditData(filme)){
            System.out.print("ENtrou");
            int index = Database.getInstancia().getFilmes().indexOf(filme);
            filme.setNome(newTitulo);
            filme.setFaixaEtaria(newFaixaEtaria);
            Database.getInstancia().getFilmes().set(index, filme);
            return true;
        }
        return false;
    }
    //REFAZER
    public void salvarArq(){
        ArqEscritor.getInstancia().cSave(Database.getInstancia().getClientes());
    }
    public void abrirArq(String path){
        ArqEscritor.getInstancia().cLoad(path);
        int index = Database.getInstancia().getClientes().size();
        Database.getInstancia().setClienteId(index);
    }
}
