package guis;


import util.Service;

import javax.swing.*;
import java.awt.*;

/**
 * Created by prulov on 03.07.2016.
 */
public class HPPanelUI {

    private Service serv;
    private JPanel hP;

    public HPPanelUI(Service serv) {
        this.serv = serv;
        this.hP = createHeadPieceUI();
    }

    public JPanel createHeadPieceUI() {

        hP = new JPanel();
        hP.setLayout(new GridBagLayout());
        hP.setBackground(Color.WHITE);

        ImageIcon icon = new ImageIcon(getClass().getResource("jew.gif"));
        JLabel picture = new JLabel(icon);
        picture.setFont(picture.getFont().deriveFont(Font.ITALIC));
        picture.setHorizontalAlignment(JLabel.LEFT);
        picture.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        hP.add(picture, new GridBagConstraints(0, 0, 0, 0, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));
        return hP;

    }
}

