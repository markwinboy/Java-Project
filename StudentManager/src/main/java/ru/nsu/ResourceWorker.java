package ru.nsu;

import ru.nsu.model.Group;

import java.io.IOException;
import java.util.List;

public interface ResourceWorker {
    public List<Group> readGroups(String directory) throws IOException;
}
