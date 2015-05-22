package com.moscona.monastery.copycat; 

import com.moscona.monastery.api.core.Node;
import net.kuujo.copycat.netty.NettyTcpProtocol;
import net.kuujo.copycat.protocol.AbstractProtocol;
import net.kuujo.copycat.protocol.LocalProtocol;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.fest.assertions.api.Assertions.*;

/** 
* CopycatNodeBuilder Tester. 
* 
* @author Arnon Moscona 
* @since <pre>May 21, 2015</pre> 
* @version 1.0 
*/ 
public class CopycatNodeBuilderTest { 

    @Before
    public void before() throws Exception { 
    }

    @After
    public void after() throws Exception {
    }

    /**
     *
     * Method: withDefaultProtocol(AbstractProtocol protocol)
     *
     */
    @Test
    public void testWithProtocolDefault() throws Exception {
        CopycatNodeBuilder builder = CopycatNodeBuilder.withDefaultProtocol();
        assertThat(builder).isNotNull();
        assertThat(builder.getProtocol()).isExactlyInstanceOf(NettyTcpProtocol.class);
    }

    /**
     *
     * Method: withProtocol(AbstractProtocol protocol)
     *
     */
    @Test
    public void testWithProtocol() throws Exception {
        AbstractProtocol protocol = new LocalProtocol();
        CopycatNodeBuilder builder = CopycatNodeBuilder.withProtocol(protocol);
        assertThat(builder).isNotNull();
        assertThat(builder.getProtocol() == protocol).isTrue();
    }

    /**
     *
     * Method: withProtocol(AbstractProtocol protocol)
     *
     */
    @Test(expected = AssertionError.class)
    public void testWithProtocolNull() throws Exception {
        CopycatNodeBuilder.withProtocol(null);
    }

    /**
     *
     * Method: add(Capability... capabilities)
     *
     */
    @Test
    public void testAdd() throws Exception {
        throw new Exception("missing test");
        //TODO: Test goes here...
    }

    /**
     *
     * Method: build()
     *
     */
    @Test
    public void testBuild() throws Exception {
        Node<String> node  = CopycatNodeBuilder.withDefaultProtocol().build();
        assertThat(node).isNotNull();
        //TODO: Test goes here...
    }


} 
