package br.com.product.registry.view;

import javax.swing.*;

public class OptionsView {

    public static Options select() {

        Options ret = (Options) JOptionPane.showInputDialog(
                null,
                "Select an option:",
                "Menu",
                JOptionPane.QUESTION_MESSAGE,
                null,
                Options.values(),
                Options.REGISTER_PRODUCT);
        return ret != null ? ret : Options.FINISH;

    }
}
