package com.pokenshin.dnd5e.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    T get(int id);

    List<T> getAll();

    void insert(T t);

    void update(T t, String[] params);

    void delete(T t);
}
