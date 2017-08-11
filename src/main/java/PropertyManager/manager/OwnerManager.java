package PropertyManager.manager;



import java.util.List;

/**
 * Created by Jan
 */
public interface OwnerManager {
    void createOwner(Owner owner);
    void updateOwner(Owner owner);
    void deleteOwner(Owner owner);
    Owner getOwnerById(Long id);
    List<Owner> findAllOwners();
    List<Owner> findOwnerBySurname(String surname);
}
