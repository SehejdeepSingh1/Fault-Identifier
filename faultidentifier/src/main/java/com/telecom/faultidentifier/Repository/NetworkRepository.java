package com.telecom.faultidentifier.Repository;

import com.telecom.faultidentifier.model.NetworkNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface NetworkRepository extends Neo4jRepository<NetworkNode,String> {

    @Query("""
            MATCH (a:NetworkNode {name: $from}),
                  (b:NetworkNode {name: $to})
            CREATE (a)-[:CONNECTED_TO]->(b)
            """)
    void connectNodes(@Param("from") String from,
                      @Param("to") String to);

    @Query("""
            MATCH (failed:NetworkNode {name:$node})
            MATCH(impactedNode:NetworkNode)-[:CONNECTED_TO*]->(failed)
            RETURN (impactedNode)
            """)
    List<NetworkNode> impactedNodes(@Param("node") String name);
}
