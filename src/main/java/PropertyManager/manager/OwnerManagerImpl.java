package PropertyManager.manager;

import PropertyManager.common.ServiceFailureException;
import java.io.Serializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jan
 */
public class OwnerManagerImpl implements OwnerManager, Serializable {

    private final static Logger log = LoggerFactory.getLogger(OwnerManagerImpl.class);

    public void createOwner(Owner owner) {
        if (owner == null) {
            throw new IllegalArgumentException("Owner is null");
        }
        if (owner.getId() != null) {
            throw new IllegalArgumentException("Id is not null");
        }
        try {
            OwnerDAO.create(owner);
        } catch (SQLException e) {
            log.error("DB connection error ", e);
            throw new ServiceFailureException("Error when creating owner", e);
        }
    }

    @Override
    public void updateOwner(Owner owner) {
        if (owner == null) {
            throw new IllegalArgumentException("Owner is null" + owner);
        }
        if (owner.getId() == null) {
            throw new IllegalArgumentException("Owner " + owner + " has id null");
        }
        if (owner.getName() == null) {
            throw new IllegalArgumentException("Owner " + owner + "has name null");
        }
        if (owner.getSurname() == null) {
            throw new IllegalArgumentException("Owner " + owner + "has surname null");
        }
        if (owner.getBorn() == null) {
            throw new IllegalArgumentException("Owner " + owner + "has date of birth null");
        }
        if (owner.getPhoneNumber() == null) {
            throw new IllegalArgumentException("Owner " + owner + "has phone number null");
        }
        if (owner.getAddressStreet() == null) {
            throw new IllegalArgumentException("Owner " + owner + "has street null");
        }
        if (owner.getAddressTown() == null) {
            throw new IllegalArgumentException("Owner " + owner + "has town null");
        }
        if (getOwnerById(owner.getId()) == null) {
            throw new IllegalArgumentException("ID" + owner + "not found");
        }
        try {
            if (!owner.getAddressStreet().equals(getOwnerById(owner.getId()).getAddressStreet()) && !owner.getSurname().equals(getOwnerById(owner.getId()).getSurname())) {
                throw new IllegalArgumentException("Cannot update owner" + owner);
            }
            OwnerDAO.update(owner);
        } catch (SQLException e) {
            log.error("DB connection error ", e);
            throw new ServiceFailureException("Error when retrieving all owners", e);
        }

    }

    @Override
    public void deleteOwner(Owner owner) {
        if (owner == null) {
            throw new IllegalArgumentException("Owner is null" + owner);
        }
        if (owner.getId() == null) {
            throw new IllegalArgumentException("Owner " + owner + " has id null");
        }
        try {
            if (!owner.equals(getOwnerById(owner.getId()))) {
                throw new IllegalArgumentException("Cannot update owner" + owner);
            }
            OwnerDAO.delete(owner.getId());
        } catch (SQLIntegrityConstraintViolationException ex) {
            throw new ServiceFailureException("Cannot delete owner with titleDeed", ex);
        } catch (SQLException e) {
            log.error("DB connection error ", e);
            throw new ServiceFailureException("Error when retrieving all owners", e);
        }

    }

    @Override
    public Owner getOwnerById(Long id) {
        Owner own = Owner.builder().build();
        if (id == null) {
            throw new IllegalArgumentException("Id is null");
        }
        try {
            own = OwnerDAO.getById(id);
        } catch (SQLException e) {
            log.error("DB connection error");
            throw new ServiceFailureException("Internal error when retrieving all owners");
        }
        return own;

    }

    @Override
    public List<Owner> findAllOwners() {
        List<Owner> list = new ArrayList<>();
        try {
            list = OwnerDAO.getAll();
        } catch (SQLException e) {
            log.error("DB connection error");
            throw new ServiceFailureException("Internal error when retrieving all owners");
        }
        return list;

    }

    @Override
    public List<Owner> findOwnerBySurname(String surname) {
        List<Owner> list = new ArrayList<Owner>();
        try {
            list = OwnerDAO.getbySurname(surname);
        } catch (SQLException e) {
            log.error("DB connection error");
            throw new ServiceFailureException("Internal error when retrieving owners by surname");
        }
        return list;
    }
}
