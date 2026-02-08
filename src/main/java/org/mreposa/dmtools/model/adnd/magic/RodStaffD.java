package org.mreposa.dmtools.model.adnd.magic;

public class RodStaffD extends MagicItemTable {
    public RodStaffD() {
        super();
    }

    @Override
    public String getMagicItem(int roll) {
        String itemName = "";

        if (roll < 7) {
            itemName = "rod of absorption";
        }
        else if (roll < 11) {
            itemName = "rod of alertness";
        }
        else if (roll == 11) {
            itemName = "rod of beguiling";
        }
        else if (roll < 22) {
            itemName = "rod of cancellation";
        }
        else if (roll < 27) {
            itemName = "rod of flailing";
        }
        else if (roll == 27) {
            itemName = "rod of lordly might";
        }
        else if (roll < 31) {
            itemName = "rod of passage";
        }
        else if (roll == 31) {
            itemName = "rod of resurrection";
        }
        else if (roll == 32) {
            itemName = "rod of rulership";
        }
        else if (roll < 37) {
            itemName = "rod of security";
        }
        else if (roll == 37) {
            itemName = "rod of smiting";
        }
        else if (roll < 41) {
            itemName = "rod of splendor";
        }
        else if (roll == 41) {
            itemName = "staff of command";
        }
        else if (roll < 49) {
            itemName = "staff of curing";
        }
        else if (roll < 56) {
            itemName = "staff-mace";
        }
        else if (roll == 56) {
            itemName = "staff of the magi";
        }
        else if (roll == 57) {
            itemName = "staff of the power";
        }
        else if (roll < 64) {
            itemName = "staff of the serpent";
        }
        else if (roll < 71) {
            itemName = "staff of slinging";
        }
        else if (roll < 77) {
            itemName = "staff-spear";
        }
        else if (roll < 83) {
            itemName = "staff of striking";
        }
        else if (roll < 86) {
            itemName = "staff of swarming insects";
        }
        else if (roll == 86) {
            itemName = "staff of thunder and lightning";
        }
        else if (roll < 91) {
            itemName = "staff of withering";
        }
        else {
            itemName = itemName + "staff of the woodlands";
        }

        return itemName;
    }
}
