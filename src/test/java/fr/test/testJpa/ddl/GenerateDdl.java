package fr.test.testJpa.ddl;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Persistence;



public class GenerateDdl {

	public static void main(String[] args) {

		Map properties = new HashMap();
		properties.put("javax.persistence.schema-generation.scripts.action", "drop-and-create");
		properties.put("javax.persistence.schema-generation.scripts.create-target", "target/scriptCreate.ddl");
		properties.put("javax.persistence.schema-generation.scripts.drop-target", "target/scriptDrop.ddl");
		
		/*select driver database*/
		/*properties.put("javax.persistence.jdbc.driver", "oracle.jdbc.OracleDriver");*/
		properties.put("javax.persistence.jdbc.driver", "org.hsqldb.jdbc.JDBCDriver");


		/*select jpa unit*/
		/*Persistence.generateSchema("testJpaUnitOracle", properties);*/
		Persistence.generateSchema("testJpaUnit-test", properties);
	}
}
