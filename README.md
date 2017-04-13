
I - Spring


-- GenerateDdl

Before run => mvn clean


-- Oracle database

Link sys
http://127.0.0.1:8080/apex/f?p=4950


- dev
eclip neon eclipse-jee-neon-1a-win32-x86_64
maven apache-maven-3.3.9-bin
git Git-2.10.1-64-bit
jdk jdk-8u101-windows-x64
oracle OracleXE112_Win64
sql sqldeveloper-4.1.5.21.78-x64

-- insert Oracle sequence example
insert INTO T_RESTAURANT(ID,NAME) VALUES (hibernate_sequence.NEXTVAL,'resto3');
INSERT INTO T_MANAGER(ID, FIRST_NAME, LAST_NAME, RESTAURANT_ID) VALUES (hibernate_sequence.NEXTVAL, 'f2', 'tes2', 1);




II - Entity manager 

	

  II. 1 - Trong truong hop dung generator id sequence mysql	
	
-- ve phan java
	
@Entity
@Table(name = "APP_RESTAURANT")
public class ReservationEntity implements Serializable{	
	
	@Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="App_Seq_Restaurant")
    @TableGenerator(name = "App_Seq_Restaurant", table = "APP_SEQUENCE", allocationSize = 1, initialValue = 0,
    pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "SEQ_RESTAURANT")
    @Column(name = "RESTAURANT_ID")
    private Long id;

}


-- ve phan sql

CREATE TABLE APP_SEQUENCE
(
    SEQ_NAME  VARCHAR(50) NOT NULL,
    SEQ_COUNT BIGINT NOT NULL,
    PRIMARY KEY(SEQ_NAME)
);

INSERT INTO APP_SEQUENCE VALUES ('APP_RESTAURANT.SEQ_RESTAURANT', 0); 


