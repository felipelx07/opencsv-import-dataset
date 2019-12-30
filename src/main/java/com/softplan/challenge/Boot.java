package com.softplan.challenge;

import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.datasources.DatasourcesFraction;

public class Boot {

    public static void main(String... args) throws Exception {
        Swarm swarm = new Swarm(args);
        swarm.fraction(new DatasourcesFraction().dataSource("PostgresDS", (ds) -> {
            ds.driverName("postgres");
        }));
        swarm.start().deploy();
    }
}
