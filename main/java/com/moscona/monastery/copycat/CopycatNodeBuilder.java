package com.moscona.monastery.copycat;

import com.moscona.monastery.api.core.Capability;
import com.moscona.monastery.api.core.Node;
import com.moscona.monastery.api.core.NodeBuilder;
import net.kuujo.copycat.netty.NettyTcpProtocol;
import net.kuujo.copycat.protocol.AbstractProtocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.plugin.dom.exception.InvalidStateException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

/**
 * Created by Arnon Moscona on 5/21/2015.
 * A NodeBuilder for all Copycat Nodes
 */
public class CopycatNodeBuilder implements NodeBuilder<String> {
    private final Logger logger = LoggerFactory.getLogger(CopycatNodeBuilder.class);
    private final AbstractProtocol protocol;
    private final ArrayList<Capability> capabilities;

    private CopycatNodeBuilder(AbstractProtocol protocol) {
        logger.trace("Creating builder with protocol {}", protocol);
        assert protocol != null;
        this.protocol = protocol;
        capabilities = new ArrayList<>();
    }

    @Override
    public NodeBuilder<String> add(Capability... capabilities) {
        assert capabilities != null;
        logger.trace("Adding {} capabilities", capabilities.length);
        this.capabilities.addAll(Arrays.asList(capabilities));
        return this;
    }

    @Override
    public Node<String> build() throws InvalidStateException {
        logger.trace("Building node...");
        logger.error("BUG! No real building going on here!");
        return null;
    }

    public static CopycatNodeBuilder withProtocol(AbstractProtocol protocol) {
        assert protocol != null;
        return new CopycatNodeBuilder(protocol);
    }

    public static CopycatNodeBuilder withDefaultProtocol() {
        return withProtocol(new NettyTcpProtocol());
    }

    public AbstractProtocol getProtocol() {
        return protocol;
    }
}
