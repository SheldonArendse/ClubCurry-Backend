package za.ac.cput.service.interfaces;

import za.ac.cput.domain.Admin;
public interface IAdminService extends IService<Admin, String>{
    public Boolean findAdminByUsername(String username);
}
