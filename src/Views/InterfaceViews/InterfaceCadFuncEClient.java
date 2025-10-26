package Views.InterfaceViews;

import java.awt.event.ActionListener;

public interface  InterfaceCadFuncEClient {
    //Get usuario
    public String getNome();

    public void addCadastro(ActionListener al);
    public void limparCampos();
}
