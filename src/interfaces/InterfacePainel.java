package interfaces;

import javax.swing.JPanel;

/**
 *
 *
 */
public abstract class InterfacePainel extends JPanel {

    public abstract InterfaceDTO getDados();
    public abstract void setDTO(InterfaceDTO dto);
    
}
