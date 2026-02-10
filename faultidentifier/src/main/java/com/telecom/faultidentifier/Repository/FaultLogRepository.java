package com.telecom.faultidentifier.Repository;

import com.telecom.faultidentifier.model.FaultLog;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;


public interface FaultLogRepository extends Neo4jRepository<FaultLog,String> {
}
