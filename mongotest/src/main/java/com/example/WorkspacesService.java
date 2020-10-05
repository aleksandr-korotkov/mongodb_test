package com.example;

import com.example.repo.WorkspacesCustomRepositoryImpl;
import com.example.repo.WorkspacesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class WorkspacesService {

    @Autowired
    private WorkspacesRepository repository;

    @Autowired
    private WorkspacesCustomRepositoryImpl workspacesCustomRepository;

    public List<Workspace> findByUnit(int unit){
        return repository.findByUnit(unit);
    }

    public List<Workspace> findByUnitAndSeat(int unit, int seat){
        return repository.findByUnitAndSeat(unit, seat);
    }

    public void save(Workspace workspace){
        repository.save(workspace);
    }

    public Workspace findMaxByUnit(){
        return workspacesCustomRepository.findMaxByUnit();
    }

    public List<Workspace> findAll(){
        return repository.findAll();
    }

    public Double getAverageByUnit(){
       return workspacesCustomRepository.getAverageByUnit();
    }

    public void updateSerialNumberIfSeatEquals(String newSerialNumber, int seat){
        workspacesCustomRepository.updateSerialNumberIfSeatEquals(newSerialNumber, seat);
    }
}
