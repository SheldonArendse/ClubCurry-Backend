package za.ac.cput.service.interfaces;

import za.ac.cput.domain.Menu;

public interface IMenuService extends IService<Menu, Long> {

    public Menu findByName(String name);
}
