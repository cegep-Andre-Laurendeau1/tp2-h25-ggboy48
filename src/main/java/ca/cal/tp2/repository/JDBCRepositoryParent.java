package ca.cal.tp2.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCRepositoryParent {

    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:mem:tp2;DB_CLOSE_DELAY=-1";

    //  Database credentials
    static final String USER = "sa";
    static final String PASS = "";

    static Connection conn = null;
    static Statement statement = null;


    static {
        // STEP 1: Register JDBC driver
        try {
            Class.forName(JDBC_DRIVER);
            conn= DriverManager.getConnection(DB_URL,USER,PASS);
            statement = conn.createStatement();
            String sql ="CREATE TABLE Document " +
                    "(id INTEGER not NULL, " +
                    " titre VARCHAR(255), " +
                    " auteur VARCHAR(255), " +
                    "anneePublication INTEGER,"+
                    "dureeEmprunt INTEGER,"+
                    "nbrInventaires INTEGER,"+
                    " PRIMARY KEY ( id ))";
            statement.executeUpdate(sql);

            //Creation la table Livre
            sql = """
            CREATE TABLE Livre (
                id INTEGER PRIMARY KEY REFERENCES Document(id),
                ISBN VARCHAR(20),
                editeur VARCHAR(255),
                nbPages INTEGER
            );
            """;
            statement.executeUpdate(sql);


            //Creation la table CD
            sql = """
            CREATE TABLE CD (
                id INTEGER PRIMARY KEY REFERENCES Document(id),
                artiste VARCHAR(20),
                duree INTEGER,
                genre VARCHAR(20)
            );
            """;
            statement.executeUpdate(sql);

            //Creation la table DVD
            sql = """
            CREATE TABLE DVD (
                id INTEGER PRIMARY KEY REFERENCES Document(id),
                directeur VARCHAR(25),
                duree INTEGER,
                rating VARCHAR(20)
            );
            """;
            statement.executeUpdate(sql);

            //Creation table Utilisateur
            sql = """
            CREATE TABLE Utilisateur (
                id INTEGER not NULL PRIMARY KEY,
                nom VARCHAR(255),
                prenom VARCHAR(255),
                email VARCHAR(255),
                phone VARCHAR(20)
            );
            """;
            statement.executeUpdate(sql);

            // Creation table Emprunteur
            sql = """
            CREATE TABLE Emprunteur (
                id INTEGER PRIMARY KEY REFERENCES Utilisateur(id),
                amendes DOUBLE   
            );
            """;
            statement.executeUpdate(sql);

            // Creation table Preposee
            sql = """
            CREATE TABLE Prepose (
                id INTEGER PRIMARY KEY REFERENCES Utilisateur(id),
                role VARCHAR(20) 
            );
            """;
            statement.executeUpdate(sql);


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
