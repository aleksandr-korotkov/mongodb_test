package com.example.repo;

import com.example.Workspace;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.springframework.data.domain.Sort.*;

@Component
public class WorkspacesCustomRepositoryImpl implements  WorkspacesCustomRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private WorkspacesRepository repository;

    public Workspace findMaxByUnit() {
        final Query query = new Query()
                .limit(1)
                .with(by(Direction.DESC, "Unit"));

        return mongoTemplate.findOne(query, Workspace.class);
    }

    public Double getAverageByUnit() {
        List<Workspace> all = repository.findAll();
        Double sum = Double.valueOf(all.stream().mapToInt(Workspace::getUnit).sum());
        return sum/all.size();
    }

    @Override
    public void updateSerialNumberIfSeatEquals(String newSerialNumber, int seat) {
        Query query = new Query(Criteria.where("seat").is(seat));
        Update update = new Update();
        update.set("serialNumber", newSerialNumber);

        UpdateResult result = mongoTemplate.updateFirst(query, update, Workspace.class);
    }
}
