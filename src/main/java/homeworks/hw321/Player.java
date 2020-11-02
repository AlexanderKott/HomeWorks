package homeworks.hw321;

import homeworks.hw321.weapon.*;

class Player {
    private Weapon[] weaponSlots;

    public Player() {
         weaponSlots = new Weapon[] {
                new Pistol(),
                new MachineGun(),
                new WaterPistol(),
                new Bazooka(),
        };
    }

    public int getSlotsCount() {
        return weaponSlots.length;
    }

    public void shotWithWeapon(int slot) throws IllegalArgumentException{

        if (slot<0 || slot >= weaponSlots.length){
            throw new IllegalArgumentException("Ошибка выбора слота");
        }
        Weapon weapon = weaponSlots[slot];
        weapon.shot();
    }
}