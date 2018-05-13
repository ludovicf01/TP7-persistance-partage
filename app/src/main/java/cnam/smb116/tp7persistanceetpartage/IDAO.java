package cnam.smb116.tp7persistanceetpartage;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by ludo on 29/03/2017.
 */

public interface IDAO<T,ID> {

    public void open() throws SQLException;

    public void close();

    public void create(T t) throws Exception;

    public T retrieve(ID id) throws Exception;

    public List<T> findAll() throws Exception;

    public void update(T t) throws Exception;

    public void delete(ID id) throws Exception;

}
