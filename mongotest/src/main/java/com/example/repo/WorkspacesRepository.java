package com.example.repo;

import com.example.Workspace;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface WorkspacesRepository extends MongoRepository<Workspace, String > {

    //@Query("{unit:'?0'}")
    List<Workspace> findByUnit(int unit);

    List<Workspace> findByUnitAndSeat(int unit, int seat);
}
