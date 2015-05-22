package com.moscona.monastery.copycat;

import com.moscona.monastery.api.core.Capability;
import com.moscona.monastery.api.core.Node;
import net.kuujo.copycat.cluster.Cluster;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

/**
 * Created by Arnon Moscona on 5/21/2015.
 * A base class for Copycat nodes.
 */
public abstract class CopycatNode implements Node<String> {
    private final String id; // may depend on the protocol used
    private final Cluster cluster;
    ArrayList<Capability> path;

    protected CopycatNode(String id, List<Capability> initialPath, Cluster cluster) {
        assert id!=null; // fail fast and completely if implementation is buggy
        path = new ArrayList<>(initialPath);
        this.id = id;
        this.cluster = cluster;
    }

    @Override
    public Optional<String> getId() {
        return Optional.ofNullable(id);
    }

    @Override
    public CompletableFuture<Optional<String>> getCapability(Class aClass) {
        return null;
    }
}
