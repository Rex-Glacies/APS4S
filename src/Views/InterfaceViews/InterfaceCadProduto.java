package Views.InterfaceViews;

import java.awt.event.ActionListener;

public interface InterfaceCadProduto {
    //Get do usuario
    public String GetCodProd();
    public String GetNomeProd();
    public double GetValorProd();
    public int GetEstoqueProd();
    public void limparCampos();

    public void AddEnviarProduto(ActionListener al);
}
