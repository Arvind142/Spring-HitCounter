#!/bin/bash
echo off
echo "####################################################################################################################"
echo ">>spinning up containers"
docker-compose up -d
echo ">>pause for few seconds until database service is up and running"
timeout 25
echo ">>creating tables"
docker cp create_table.sql postgres-demo:/create_table.sql
docker exec -it postgres-demo psql -d conference_app -f create_table.sql -U postgres
timeout 5
echo "####################################################################################################################"
echo ">>database should be up and running use below conf for postgres database"
echo "---------------------------------------------------------------------------------"
echo "| JDBC URL: jdbc:postgresql://localhost:5432/trackerDB                     |"
echo "| Username: postgres                                                            |"
echo "| Password: new_se3ret_password_test                                            |"
echo "|-------------------------------------------------------------------------------|"
echo "| Adminer UI: http://localhost:5001  - UI to peform DB operations               |"
echo "| Details:                                                                      |"
echo "|   System:   PostgreSQL                                                        |"
echo "|   Server:   postgres-demo                                                     |"
echo "|   username: postgres                                                          |"
echo "|   password: new_se3ret_password_test                                          |"
echo "|   Database: trackerDB                                                    |"
echo "---------------------------------------------------------------------------------"
echo "####################################################################################################################"
echo ">>to stop everything run 'docker-compose down' command "
echo "####################################################################################################################"