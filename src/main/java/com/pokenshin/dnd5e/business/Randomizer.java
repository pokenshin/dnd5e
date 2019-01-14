package com.pokenshin.dnd5e.business;

import com.pokenshin.dnd5e.entity.*;
import com.pokenshin.dnd5e.entity.Character;
import com.pokenshin.dnd5e.util.JsonMapper;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.prefs.BackingStoreException;

public class Randomizer {
    private Random rng;

    public Randomizer(){
        rng = new Random();
    }

    /**
     * Returns a random race from the json list of races in the resources folder.
     * @return Race object randomly built from the list of races in the resources folder.
     */
    public Race getRandomRace(){
        JsonMapper mapper = new JsonMapper();
        Map<Integer, Race> raceList = mapper.getAllRaces();
        Race race = raceList.get(ThreadLocalRandom.current().nextInt(1, raceList.size()));
        return race;
    }

    public CharacterClass getRandomClass(){
        JsonMapper mapper = new JsonMapper();
        Map<Integer, CharacterClass> classList = mapper.getAllCharacterClasses();
        CharacterClass characterClass = classList.get(ThreadLocalRandom.current().nextInt(1,classList.size()));
        return characterClass;
    }

    public int getRandomHeight(Race race){
        int result = race.getBaseHeight();
        DiceBusiness dice = new DiceBusiness(race.getHeightModifier());
        result = result + dice.getRoll();
        return result;
    }

    public int getRandomWeight(Race race){
        int result = race.getBaseWeight();
        DiceBusiness dice = new DiceBusiness(race.getWeightModifier());
        result = result + dice.getRoll();
        return result;
    }

    public CharacterBackground getRandomBackground(){
        JsonMapper mapper = new JsonMapper();
        Map<Integer, CharacterBackground> bgList = mapper.getAllCharacterBackgrounds();
        CharacterBackground background = bgList.get(ThreadLocalRandom.current().nextInt(1, bgList.size()));
        return background;
    }

    public String getRandomListItemString(List<String> list){
        if (list.size() > 0){
            return list.get(ThreadLocalRandom.current().nextInt(0, list.size()));
        } else return null;
    }

    public String getRandomAlignment() {
        List<String> possibleAligments = Arrays.asList("Lawful Good", "Lawful Neutral", "Lawful Evil", "Neutral Good", "True Neutral", "Neutral Evil", "Chaotic Good", "Chaotic Neutral", "Chaotic Evil");
        return this.getRandomListItemString(possibleAligments);
    }

    public Character generateBalancedAbilityScores(int totalPoints, Character character){
        if (totalPoints < 6)
            totalPoints = 6;
        totalPoints -= 6;
        List<Integer> values = Arrays.asList(1,1,1,1,1,1);
        int iteration = 0;

        while(iteration < totalPoints){
            int position = ThreadLocalRandom.current().nextInt(0, 6);
            values.set(position, values.get(position) + 1);
            iteration += 1;
        }
        character.getStrength().setValue(values.get(0));
        character.getDexterity().setValue(values.get(1));
        character.getConstitution().setValue(values.get(2));
        character.getIntelligence().setValue(values.get(3));
        character.getWisdom().setValue(values.get(4));
        character.getCharisma().setValue(values.get(5));

        return character;
    }

    public Weapon getRandomWeapon(){
        JsonMapper mapper = new JsonMapper();
        Object[] wpList = mapper.getAllWeapons().values().toArray();
        Weapon weapon = (Weapon)wpList[ThreadLocalRandom.current().nextInt(0, wpList.length - 1)];
        return weapon;
    }

    public Armor getRandomArmor(){
        JsonMapper mapper = new JsonMapper();
        Object[] wpList = mapper.getAllArmors().values().toArray();
        Armor armor = (Armor)wpList[ThreadLocalRandom.current().nextInt(0, wpList.length - 1)];
        return armor;
    }

    public Weapon getRandomWeaponByCategory(String category){
        JsonMapper mapper = new JsonMapper();
        Object[] wpList = mapper.getAllWeaponsByCategory(category).values().toArray();
        Weapon weapon = (Weapon)wpList[ThreadLocalRandom.current().nextInt(0, wpList.length - 1)];
        return weapon;
    }

    /**
     * Generates a random level 1 Character object.
     * @return A Character object with random values set to level 1.
     */
    public Character getRandomCharacter(int totalAbilityValues){
        Character result = new Character();
        CharacterBusiness characterBusiness = new CharacterBusiness();

        result.setLevel(1);
        result.setExperience(0);
        result.setAlignment(this.getRandomAlignment());
        result.setCharacterName("Random Character");
        result.setPlayerName("The Computer");
        result = this.generateBalancedAbilityScores(totalAbilityValues, result);
        result.getStrength().setModifier(characterBusiness.getModifier(result.getStrength().getValue()));
        result.getDexterity().setModifier(characterBusiness.getModifier(result.getDexterity().getValue()));
        result.getConstitution().setModifier(characterBusiness.getModifier(result.getConstitution().getValue()));
        result.getIntelligence().setModifier(characterBusiness.getModifier(result.getIntelligence().getValue()));
        result.getWisdom().setModifier(characterBusiness.getModifier(result.getWisdom().getValue()));
        result.getCharisma().setModifier(characterBusiness.getModifier(result.getCharisma().getValue()));
        characterBusiness.applyRace(result, this.getRandomRace());
        characterBusiness.applyCharacterClass(result, this.getRandomClass());
        characterBusiness.applyBackground(result, this.getRandomBackground());
        result.setHeight(this.getRandomHeight(result.getRace()));
        result.setWeight(this.getRandomWeight(result.getRace()));
        result.setEquipment(this.getRandomStartingEquipment(result.getCharacterClass()));

        result = characterBusiness.calculateNewCharacter(result);
        //TODO: Define spells if applicable. Based on class. Spell attack bonus = primary spellcasting stat + proficiency bonus.

        return result;
    }

    /**
     * Returns a randomized list of starting equipment for the Bard class
     * @return List<Item> of starting equipment
     */
    public ArrayList<Item> getRandomStartingEquipmentBard() {
        ItemBusiness itemBusiness = new ItemBusiness();
        ArrayList<Item> weapons = new ArrayList<>();
        ArrayList<ArrayList<Item>> packs = new ArrayList<>();
        ArrayList<Item> tools = new ArrayList<>();
        JsonMapper mapper = new JsonMapper();
        weapons.add(mapper.getWeapon("rapier.json"));
        weapons.add(mapper.getWeapon("longsword.json"));
        weapons.add(this.getRandomWeaponByCategory("Simple Weapon"));
        packs.add(itemBusiness.getItemPack("Diplomat"));
        packs.add(itemBusiness.getItemPack("Entertainer"));
        tools.add(mapper.getTool("lute.json"));
        tools.add(this.getRandomToolItemByCategory("Musical Instrument"));
        ArrayList<Item> equipment = new ArrayList<Item>();
        equipment.add(weapons.get(ThreadLocalRandom.current().nextInt(0, weapons.size())));
        equipment.addAll(packs.get(ThreadLocalRandom.current().nextInt(0, packs.size())));
        equipment.add(tools.get(ThreadLocalRandom.current().nextInt(0, tools.size())));
        equipment.add(mapper.getWeapon("dagger.json"));
        equipment.add(mapper.getArmor("leather.json"));

        return equipment;
    }

    public Item getRandomToolItemByCategory(String category) {
        JsonMapper mapper = new JsonMapper();
        Object[] itemList = mapper.getToolsByCategory(category).values().toArray();
        Item item = (Item)itemList[ThreadLocalRandom.current().nextInt(0, itemList.length - 1)];
        return item;
    }

    /**
     * Returns a randomized list of starting equipment for the Barbarian class
     * @return ArrayList<Item> of starting equipment
     */
    private ArrayList<Item> getRandomStartingEquipmentBarbarian() {
        ItemBusiness itemBusiness = new ItemBusiness();
        ArrayList<Item> result = new ArrayList<>();
        ArrayList<Item> weaponsA = new ArrayList<>();
        ArrayList<Item> weaponsB = new ArrayList<>();
        JsonMapper mapper = new JsonMapper();
        Weapon greataxe = mapper.getWeapon("greataxe.json");
        Weapon handaxe = mapper.getWeapon("handaxe.json");
        Weapon randomMartial = this.getRandomWeaponByCategory("Martial Weapon");
        Weapon randomSimple = this.getRandomWeaponByCategory("Simple Weapon");
        Weapon javelin = mapper.getWeapon("javelin.json");
        weaponsA.add(greataxe);
        weaponsA.add(randomMartial);
        weaponsB.add(handaxe);
        weaponsB.add(randomSimple);
        result.add(weaponsA.get(ThreadLocalRandom.current().nextInt(0, weaponsA.size())));
        result.add(weaponsB.get(ThreadLocalRandom.current().nextInt(0, weaponsB.size())));
        if (result.get(1).getName().equals("Handaxe")){
            result.add(handaxe);
        }
        for(int i = 0; i< 4; i++){
            result.add(javelin);
        }
        result.addAll(itemBusiness.getItemPack("Explorer"));
        return result;
    }

    /**
     * Returns a list of random equipment options for the Class/Background combo
     * @param characterClass
     * @return
     */
    public ArrayList<Item> getRandomStartingEquipment(CharacterClass characterClass){
        switch (characterClass.getName()){
            case "Barbarian":
                return this.getRandomStartingEquipmentBarbarian();
            case "Bard":
                return this.getRandomStartingEquipmentBard();
            case "Cleric":
                return this.getRandomStartingEquipmentCleric();
            case "Druid":
                return this.getRandomStartingEquipmentDruid();
            case "Fighter":
                return getRandomStartingEquipmentFighter();
            case "Monk":
                return getRandomStartingEquipmentMonk();
            case "Paladin":
                return getRandomStartingEquipmentPaladin();
            case "Ranger":
                return getRandomStartingEquipmentRanger();
            case "Rogue":
                return getRandomStartingEquipmentRogue();
            case "Sorcerer":
                return null;
            case "Warlock":
                return null;
            case "Wizard":
                return null;

            default:
                return new ArrayList<>();
        }
    }

    /**
     * Returns a randomized list of starting equipment for the Rogue class
     * @return ArrayList<Item> of starting equipment
     */
    private ArrayList<Item> getRandomStartingEquipmentRogue() {
        ItemBusiness itemBusiness = new ItemBusiness();
        ArrayList<Item> result = new ArrayList<>();
        JsonMapper mapper = new JsonMapper();
        ArrayList<Item> groupOne = new ArrayList<>();
        ArrayList<Item> groupTwo = new ArrayList<>();
        ArrayList<ArrayList<Item>> packs = new ArrayList<>();
        groupOne.add(mapper.getWeapon("rapier.json"));
        groupOne.add(mapper.getWeapon("shortsword.json"));
        result.add(groupOne.get(ThreadLocalRandom.current().nextInt(0, groupOne.size())));
        groupTwo.add(mapper.getWeapon("shortbow.json"));
        groupTwo.add(mapper.getWeapon("shortsword.json"));
        result.add(groupTwo.get(ThreadLocalRandom.current().nextInt(0, groupTwo.size())));
        if (result.get(result.size() - 1).getName().equals("Short Bow")){
            Item arrow = mapper.getMiscItem("arrow.json");
            arrow.setQuantity(20);
            result.add(arrow);
        }
        packs.add(itemBusiness.getItemPack("Burglar"));
        packs.add(itemBusiness.getItemPack("Dungeoneer"));
        packs.add(itemBusiness.getItemPack("Explorer"));
        result.addAll(packs.get(ThreadLocalRandom.current().nextInt(0, packs.size())));

        return result;
    }

    /**
     * Returns a randomized list of starting equipment for the Ranger class
     * @return ArrayList<Item> of starting equipment
     */
    private ArrayList<Item> getRandomStartingEquipmentRanger() {
        ItemBusiness itemBusiness = new ItemBusiness();
        ArrayList<Item> result = new ArrayList<>();
        JsonMapper mapper = new JsonMapper();
        ArrayList<Item> groupOne = new ArrayList<>();
        ArrayList<Item> groupTwo = new ArrayList<>();
        ArrayList<ArrayList<Item>> groupThree = new ArrayList<>();
        groupOne.add(mapper.getArmor("scale.json"));
        groupOne.add(mapper.getArmor("leather.json"));
        result.add(groupOne.get(ThreadLocalRandom.current().nextInt(0, groupOne.size())));
        Weapon shortsword = mapper.getWeapon("shortsword.json");
        Weapon simpleWeapon = this.getRandomWeaponByCategory("Simple Weapon");
        groupTwo.add(shortsword);
        groupTwo.add(simpleWeapon);
        result.add(groupTwo.get(ThreadLocalRandom.current().nextInt(0, groupTwo.size())));
        if (result.get(result.size() - 1).getName().equals("Short Sword")){
            result.get(result.size()-1).setQuantity(2);
        } else {
            result.add(this.getRandomWeaponByCategory("Simple Weapon"));
        }
        groupThree.add(itemBusiness.getItemPack("Dungeoneer"));
        groupThree.add(itemBusiness.getItemPack("Explorer"));
        result.addAll(groupThree.get(ThreadLocalRandom.current().nextInt(0, groupThree.size())));
        result.add(mapper.getWeapon("longbow.json"));
        Item arrow = mapper.getMiscItem("arrow.json");
        arrow.setQuantity(20);
        result.add(arrow);

        return result;
    }

    /**
     * Returns a randomized list of starting equipment for the Paladin class
     * @return ArrayList<Item> of starting equipment
     */
    private ArrayList<Item> getRandomStartingEquipmentPaladin() {
        ItemBusiness itemBusiness = new ItemBusiness();
        ArrayList<Item> result = new ArrayList<>();
        JsonMapper mapper = new JsonMapper();
        ArrayList<Item> groupOne = new ArrayList<>();
        ArrayList<Item> groupTwo = new ArrayList<>();
        ArrayList<ArrayList<Item>> groupThree = new ArrayList<>();
        groupOne.add(this.getRandomWeaponByCategory("Martial Weapon"));
        groupOne.add(mapper.getArmor("shield.json"));
        result.add(groupOne.get(ThreadLocalRandom.current().nextInt(0, groupOne.size())));
        result.add((this.getRandomWeaponByCategory("Martial Weapon")));
        Weapon javelin = mapper.getWeapon("javelin.json");
        javelin.setQuantity(10);
        groupTwo.add(javelin);
        groupTwo.add(this.getRandomWeaponByCategory("Simple Weapon"));
        result.add(groupTwo.get(ThreadLocalRandom.current().nextInt(0, groupTwo.size())));
        groupThree.add(itemBusiness.getItemPack("Priest"));
        groupThree.add(itemBusiness.getItemPack("Explorer"));
        result.addAll(groupThree.get(ThreadLocalRandom.current().nextInt(0, groupThree.size())));
        result.add(mapper.getArmor("chainmail.json"));
        result.add(mapper.getMiscItem("holysymbol.json"));

        return result;
    }

    /**
     * Returns a randomized list of starting equipment for the Monk class
     * @return ArrayList<Item> of starting equipment
     */
    private ArrayList<Item> getRandomStartingEquipmentMonk() {
        ItemBusiness itemBusiness = new ItemBusiness();
        ArrayList<Item> result = new ArrayList<>();
        JsonMapper mapper = new JsonMapper();
        ArrayList<Item> groupOne = new ArrayList<>();
        ArrayList<ArrayList<Item>> groupTwo = new ArrayList<>();
        Weapon dart = mapper.getWeapon("dart.json");
        dart.setQuantity(10);
        groupOne.add(mapper.getWeapon("shortsword.json"));
        groupOne.add(this.getRandomWeaponByCategory("Simple Weapon"));
        result.add(groupOne.get(ThreadLocalRandom.current().nextInt(0, groupOne.size())));
        groupTwo.add(itemBusiness.getItemPack("Dungeoneer"));
        groupTwo.add(itemBusiness.getItemPack("Explorer"));
        result.addAll(groupTwo.get(ThreadLocalRandom.current().nextInt(0, groupTwo.size())));
        result.add(dart);

        return result;
    }

    /**
     * Returns a randomized list of starting equipment for the Cleric class
     * @return ArrayList<Item> of starting equipment
     */
    private ArrayList<Item> getRandomStartingEquipmentCleric() {
        ItemBusiness itemBusiness = new ItemBusiness();
        ArrayList<Item> result = new ArrayList<>();
        JsonMapper mapper = new JsonMapper();
        ArrayList<Item> weapons = new ArrayList<>();
        ArrayList<Item> armor = new ArrayList<>();
        ArrayList<Item> extra = new ArrayList<>();
        ArrayList<ArrayList<Item>> packs = new ArrayList<>();
        weapons.add(mapper.getWeapon("mace.json"));
        weapons.add(mapper.getWeapon("warhammer.json"));
        armor.add(mapper.getArmor("scale.json"));
        armor.add(mapper.getArmor("leather.json"));
        armor.add(mapper.getArmor("chainmail.json"));
        extra.add(mapper.getWeapon("lightcrossbow.json"));
        extra.add(this.getRandomWeaponByCategory("Simple Weapon"));
        packs.add(itemBusiness.getItemPack("Priest"));
        packs.add(itemBusiness.getItemPack("Explorer"));
        result.add(mapper.getArmor("shield.json"));
        result.add(mapper.getMiscItem("holysymbol.json"));
        result.add(weapons.get(ThreadLocalRandom.current().nextInt(0, weapons.size())));
        result.add(armor.get(ThreadLocalRandom.current().nextInt(0, armor.size())));
        result.add(extra.get(ThreadLocalRandom.current().nextInt(0, extra.size())));
        if (result.get(result.size() - 1).getName().equals("Light Crossbow")){
            Item bolt = mapper.getMiscItem("bolt.json");
            bolt.setQuantity(20);
            result.add(bolt);
        }
        return result;
    }

    /**
     * Returns a randomized list of starting equipment for the Druid class
     * @return ArrayList<Item> of starting equipment
     */
    private ArrayList<Item> getRandomStartingEquipmentDruid() {
        ItemBusiness itemBusiness = new ItemBusiness();
        ArrayList<Item> result = new ArrayList<>();
        JsonMapper mapper = new JsonMapper();
        ArrayList<Item> groupOne = new ArrayList<>();
        ArrayList<Item> groupTwo = new ArrayList<>();
        groupOne.add(mapper.getWeapon("scimitar.json"));
        groupOne.add(this.getRandomWeaponByCategory("Simple Weapon"));
        result.add(groupOne.get(ThreadLocalRandom.current().nextInt(0, groupOne.size())));
        groupTwo.add(mapper.getArmor("shield.json"));
        groupTwo.add(this.getRandomWeaponByCategory("Simple Weapon"));
        result.add(groupTwo.get(ThreadLocalRandom.current().nextInt(0, groupTwo.size())));
        result.add(mapper.getArmor("leather.json"));
        result.addAll(itemBusiness.getItemPack("Explorer"));
        result.add(mapper.getMiscItem("druidicfocus.json"));

        return result;
    }

    /**
     * Returns a randomized list of starting equipment for the Fighter class
     * @return ArrayList<Item> of starting equipment
     */
    private ArrayList<Item> getRandomStartingEquipmentFighter() {
        ItemBusiness itemBusiness = new ItemBusiness();
        ArrayList<Item> result = new ArrayList<>();
        JsonMapper mapper = new JsonMapper();
        ArrayList<Item> groupOne = new ArrayList<>();
        ArrayList<Item> groupTwo = new ArrayList<>();
        ArrayList<Item> groupThree = new ArrayList<>();
        ArrayList<ArrayList<Item>> groupFour = new ArrayList<>();
        groupOne.add(mapper.getArmor("chainmail.json"));
        groupOne.add(mapper.getArmor("leather.json"));
        result.add(groupOne.get(ThreadLocalRandom.current().nextInt(0, groupOne.size())));
        if (result.get(0).getName().equals("Leather Armor")){
            result.add(mapper.getWeapon("longbow.json"));
            Item arrow = mapper.getMiscItem("arrow.json");
            arrow.setQuantity(20);
            result.add(arrow);
        }
        groupTwo.add(mapper.getArmor("shield.json"));
        groupTwo.add(this.getRandomWeaponByCategory("Martial Weapon"));
        result.add(groupTwo.get(ThreadLocalRandom.current().nextInt(0, groupTwo.size())));
        result.add(this.getRandomWeaponByCategory("Martial Weapon"));
        groupThree.add(mapper.getWeapon("lightcrossbow.json"));
        groupThree.add(mapper.getWeapon("handaxe.json"));
        result.add(groupThree.get(ThreadLocalRandom.current().nextInt(0, groupThree.size())));
        if (result.get(result.size() - 1).getName().equals("Light Crossbow")){
            Item bolt = mapper.getMiscItem("bolt.json");
            bolt.setQuantity(20);
            result.add(bolt);
        } else{
            result.get(result.size()-1).setQuantity(2);
        }
        groupFour.add(itemBusiness.getItemPack("Dungeoneer"));
        groupFour.add(itemBusiness.getItemPack("Explorer"));
        result.addAll(groupFour.get(ThreadLocalRandom.current().nextInt(0, groupFour.size())));

        return result;
    }
}
