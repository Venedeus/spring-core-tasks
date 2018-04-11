package com.epam.cources.springcore.daos;

import java.util.List;

/**
 * Created by Evgeniy on 21.03.2018.
 */
public interface DAO<T> {
    List<T> getInputs();
    void saveInputs(List<T> listOfInputs);
    void saveInputs(String path, List<T> listOfInputs);
}
