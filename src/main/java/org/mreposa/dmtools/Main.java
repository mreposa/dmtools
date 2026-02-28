package org.mreposa.dmtools;

import org.mreposa.dmtools.view.adnd.StatFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(StatFrame::new);
    }
}