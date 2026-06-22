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

    public List<MagicItem> generate(int count, String type) {
        List<MagicItem> magicItemList;
        MagicItem magicItem;
        Roll roll;
        int itemTableRoll;
        MagicItemTable itemTable;

        if (type.equals(MagicItemTable.MAGIC_ITEM_TYPES[0])) {
            magicItemList = this.generate(count);
        }
        else {
            magicItemList = new ArrayList<>();

            for (int i = 0; i < count; i++) {
                roll = this.diceRollGenerator.roll(1, 100);
                itemTableRoll = roll.getTotal();

                // Magic item table
                if (type.equals(MagicItemTable.MAGIC_ITEM_TYPES[1])) {
                    if (itemTableRoll < 66) {
                        itemTable = new PotionA(this.diceRollGenerator);
                    } else {
                        itemTable = new PotionA2(this.diceRollGenerator);
                    }
                } else if (type.equals(MagicItemTable.MAGIC_ITEM_TYPES[2])) {
                    if (itemTableRoll < 86) {
                        itemTable = new ScrollB(this.diceRollGenerator);
                    } else {
                        itemTable = new ScrollB2(this.diceRollGenerator);
                    }
                } else if (type.equals(MagicItemTable.MAGIC_ITEM_TYPES[3])) {
                    if (itemTableRoll < 68) {
                        itemTable = new RingC(this.diceRollGenerator);
                    } else {
                        itemTable = new RingC2(this.diceRollGenerator);
                    }
                } else if (type.equals(MagicItemTable.MAGIC_ITEM_TYPES[4])) {
                    itemTable = new RodStaffD(this.diceRollGenerator);
                } else if (type.equals(MagicItemTable.MAGIC_ITEM_TYPES[5])) {
                    itemTable = new WandD2(this.diceRollGenerator);
                } else if (type.equals(MagicItemTable.MAGIC_ITEM_TYPES[6])) {
                    if (itemTableRoll < 15) {
                        itemTable = new MiscMagicE(this.diceRollGenerator);
                    } else if (itemTableRoll < 29) {
                        itemTable = new MiscMagicE2(this.diceRollGenerator);
                    } else if (itemTableRoll < 43) {
                        itemTable = new MiscMagicE3(this.diceRollGenerator);
                    } else if (itemTableRoll < 57) {
                        itemTable = new MiscMagicE4(this.diceRollGenerator);
                    } else if (itemTableRoll < 71) {
                        itemTable = new MiscMagicE5(this.diceRollGenerator);
                    } else if (itemTableRoll < 86) {
                        itemTable = new MiscMagicE6(this.diceRollGenerator);
                    } else {
                        itemTable = new MiscMagicE7(this.diceRollGenerator);
                    }
                } else if (type.equals(MagicItemTable.MAGIC_ITEM_TYPES[7])) {
                    if (itemTableRoll < 51) {
                        itemTable = new ArmorShieldF(this.diceRollGenerator);
                    } else {
                        itemTable = new ArmorShieldF2(this.diceRollGenerator);
                    }
                } else if (type.equals(MagicItemTable.MAGIC_ITEM_TYPES[8])) {
                    if (itemTableRoll < 96) {
                        itemTable = new SwordG(this.diceRollGenerator);
                    } else {
                        itemTable = new SwordG2(this.diceRollGenerator);
                    }
                } else {
                    if (itemTableRoll < 51) {
                        itemTable = new MiscWeaponH(this.diceRollGenerator);
                    } else {
                        itemTable = new MiscWeaponH2(this.diceRollGenerator);
                    }
                }

                magicItem = new MagicItem();
                magicItem.setName(itemTable.getMagicItem());

                magicItemList.add(magicItem);
            }
        }

        return magicItemList;
    }

    private List<MagicItem> generate(int count) {
        ArrayList<MagicItem> magicItemList = new ArrayList<>();
        MagicItem magicItem;
        Roll roll;
        int itemTypeRoll;
        int itemTableRoll;
        MagicItemTable itemTable;

        for (int i = 0; i < count; i++) {
            roll = this.diceRollGenerator.roll(1, 100);
            itemTypeRoll = roll.getTotal();
            roll = this.diceRollGenerator.roll(1, 100);
            itemTableRoll = roll.getTotal();

            // Magic item table
            if (itemTypeRoll < 21) {
                if (itemTableRoll < 66) {
                    itemTable = new PotionA(this.diceRollGenerator);
                }
                else {
                    itemTable = new PotionA2(this.diceRollGenerator);
                }
            }
            else if (itemTypeRoll < 36) {
                if (itemTableRoll < 86) {
                    itemTable = new ScrollB(this.diceRollGenerator);
                }
                else {
                    itemTable = new ScrollB2(this.diceRollGenerator);
                }
            }
            else if (itemTypeRoll < 41) {
                if (itemTableRoll < 68) {
                    itemTable = new RingC(this.diceRollGenerator);
                }
                else {
                    itemTable = new RingC2(this.diceRollGenerator);
                }
            }
            else if (itemTypeRoll < 46) {
                if (itemTableRoll < 41) {
                    itemTable = new RodStaffD(this.diceRollGenerator);
                }
                else {
                    itemTable = new WandD2(this.diceRollGenerator);
                }
            }
            else if (itemTypeRoll < 61) {
                if (itemTableRoll < 15) {
                    itemTable = new MiscMagicE(this.diceRollGenerator);
                }
                else if (itemTableRoll < 29) {
                    itemTable = new MiscMagicE2(this.diceRollGenerator);
                }
                else if (itemTableRoll < 43) {
                    itemTable = new MiscMagicE3(this.diceRollGenerator);
                }
                else if (itemTableRoll < 57) {
                    itemTable = new MiscMagicE4(this.diceRollGenerator);
                }
                else if (itemTableRoll < 71) {
                    itemTable = new MiscMagicE5(this.diceRollGenerator);
                }
                else if (itemTableRoll < 86) {
                    itemTable = new MiscMagicE6(this.diceRollGenerator);
                }
                else {
                    itemTable = new MiscMagicE7(this.diceRollGenerator);
                }
            }
            else if (itemTypeRoll < 76) {
                if (itemTableRoll < 51) {
                    itemTable = new ArmorShieldF(this.diceRollGenerator);
                }
                else {
                    itemTable = new ArmorShieldF2(this.diceRollGenerator);
                }
            }
            else if (itemTypeRoll < 87) {
                if (itemTableRoll < 96) {
                    itemTable = new SwordG(this.diceRollGenerator);
                }
                else {
                    itemTable = new SwordG2(this.diceRollGenerator);
                }
            }
            else {
                if (itemTableRoll < 51) {
                    itemTable = new MiscWeaponH(this.diceRollGenerator);
                }
                else {
                    itemTable = new MiscWeaponH2(this.diceRollGenerator);
                }
            }

            magicItem = new MagicItem();
            magicItem.setName(itemTable.getMagicItem());

            magicItemList.add(magicItem);
        }

        return magicItemList;
    }
}
