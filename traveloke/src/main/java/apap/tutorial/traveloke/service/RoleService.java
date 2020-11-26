package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.RoleModel;
import apap.tutorial.traveloke.repository.RoleDb;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface RoleService {
    List<RoleModel> findAll();
}
