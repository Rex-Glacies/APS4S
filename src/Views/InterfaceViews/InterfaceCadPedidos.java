package Views.InterfaceViews;

import java.awt.event.ActionListener;

public interface InterfaceCadPedidos {
    
    public void AddenviarPedido(ActionListener ln);

    //Get do usuario
    public int codCliente();
    public int codFunc();
    public String codProd();
    public int quant();
}