package com.example.repo;

import com.example.Workspace;

public interface WorkspacesCustomRepository {
    Workspace findMaxByUnit();

    Double getAverageByUnit();

    void updateSerialNumberIfSeatEquals(String newSerialNumber, int seat);
}
