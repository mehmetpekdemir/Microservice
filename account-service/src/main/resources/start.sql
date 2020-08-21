CREATE KEYSPACE springcloud
	WITH replication = {'class':'SimpleStrategy','replication_factor':3};