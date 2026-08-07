package cl.mycroft.ms.laboratory.service;

public interface CrudService {

    public String getList();

    public String getListById(String id);

    public String getListByFilter(String filter);

    public String getListByFilter(String filter, int page, int pageSize);

    public String insert(String object);
    public String update(String object);
    public String delete(String id);
}
