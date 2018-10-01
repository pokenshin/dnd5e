package com.pokenshin.dnd5e.character;

import com.pokenshin.dnd5e.Spell;

import java.util.ArrayList;
import java.util.List;

public class CharacterSpellcastingClass {
    private CharacterClass characterClass;
    private int ability;
    private int save;
    private int spellAttackBonus;
    private List<Spell> spells;

    public CharacterSpellcastingClass(CharacterClass characterClass, int ability, int save, int spellAttackBonus, List<Spell> spells) {
        this.characterClass = characterClass;
        this.ability = ability;
        this.save = save;
        this.spellAttackBonus = spellAttackBonus;
        this.spells = spells;
    }

    public CharacterSpellcastingClass() {
        this.characterClass = new CharacterClass();
        this.ability = 0;
        this.save = 0;
        this.spellAttackBonus = 0;
        this.spells = new ArrayList();
    }

    public CharacterClass getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(CharacterClass characterClass) {
        this.characterClass = characterClass;
    }

    public int getAbility() {
        return ability;
    }

    public void setAbility(int ability) {
        this.ability = ability;
    }

    public int getSave() {
        return save;
    }

    public void setSave(int save) {
        this.save = save;
    }

    public int getSpellAttackBonus() {
        return spellAttackBonus;
    }

    public void setSpellAttackBonus(int spellAttackBonus) {
        this.spellAttackBonus = spellAttackBonus;
    }

    public List<Spell> getSpells() {
        return spells;
    }

    public void setSpells(List<Spell> spells) {
        this.spells = spells;
    }
}
