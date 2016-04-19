package dao.plantilla;

import java.util.ArrayList;

public interface DAO<E,I> {    
    public int add(E entidad) throws Exception;
    public int delete(I id) throws Exception;
    public int update(E entidad) throws Exception;
    public boolean exists(E entidad) throws Exception;
    public ArrayList<E> findAll(E entidad) throws Exception;
}

