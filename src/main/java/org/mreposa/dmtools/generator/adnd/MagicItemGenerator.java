package org.mreposa.dmtools.generator.adnd;

import org.mreposa.dmtools.model.adnd.magic.*;
import org.mreposa.dmtools.model.roll.Roll;

import java.util.ArrayList;
import java.util.List;

public class MagicItemGenerator {
    private final DiceRollGenerator diceRollGenerator;

    public MagicItemGenerator() {
        this.diceRollGenerator = new DiceRollGenerator();
    }

    public MagicItemGenerator(DiceRollGenerator diceRollGenerator) {
        this.diceRollGenerator = diceRollGenerator;
    }

    public List<MagicItem> generate(int count) {
        ArrayList<MagicItem> magicItemList = new ArrayList<>();
        MagicItem magicItem;
        Roll roll;
        int itemTypeRoll;
        int itemTableRoll;
        int itemRoll;
        MagicItemTable itemTable = new PotionA();
        for (int i = 0; i < count; i++) {
            roll = this.diceRollGenerator.roll(1, 100);
            itemTypeRoll = roll.getTotal();
            roll = this.diceRollGenerator.roll(1, 100);
            itemTableRoll = roll.getTotal();
            roll = this.diceRollGenerator.roll(1, 100);
            itemRoll = roll.getTotal();

            // Magic item table
            if (itemTypeRoll < 21) {
                if (itemTableRoll < 66) {
                    itemTable = new PotionA();
                }
                else {
                    itemTable = new PotionA2();
                }
            }
            else if (itemTypeRoll < 36) {
                if (itemTableRoll < 86) {
                    itemTable = new ScrollB();
                }
                else {
                    itemTable = new ScrollB2();
                }
            }
            else if (itemTypeRoll < 41) {
                if (itemTableRoll < 68) {
                    itemTable = new RingC();
                }
                else {
                    itemTable = new RingC2();
                }
            }
            else if (itemTypeRoll < 46) {
                if (itemTableRoll < 41) {
                    itemTable = new RodStaffD();
                }
                else {
                    itemTable = new WandD2();
                }
            }
            else if (itemTypeRoll < 61) {
                if (itemTableRoll < 15) {
                    itemTable = new MiscMagicE();
                }
                else if (itemTableRoll < 29) {
                    itemTable = new MiscMagicE2();
                }
                else if (itemTableRoll < 43) {
                    itemTable = new MiscMagicE3();
                }
                else if (itemTableRoll < 57) {
                    itemTable = new MiscMagicE4();
                }
                else if (itemTableRoll < 71) {
                    itemTable = new MiscMagicE5();
                }
                else if (itemTableRoll < 86) {
                    itemTable = new MiscMagicE6();
                }
                else {
                    itemTable = new MiscMagicE7();
                }
            }
            else if (itemTypeRoll < 76) {
                if (itemTableRoll < 51) {
                    itemTable = new ArmorShieldF();
                }
                else {
                    itemTable = new ArmorShieldF2();
                }
            }
            else if (itemTypeRoll < 87) {
                if (itemTableRoll < 96) {
                    itemTable = new SwordG();
                }
                else {
                    itemTable = new SwordG2();
                }
            }
            else {
                if (itemTableRoll < 51) {
                    itemTable = new MiscWeaponH();
                }
                else {
                    itemTable = new MiscWeaponH2();
                }
            }

            magicItem = new MagicItem();
            magicItem.setName(itemTable.getMagicItem(itemRoll));

            magicItemList.add(magicItem);
        }

        return magicItemList;
    }
}
