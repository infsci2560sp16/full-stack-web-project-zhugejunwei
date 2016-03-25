// import static javax.measure.unit.SI.KILOGRAM;
// import javax.measure.quantity.Mass;
// import org.jscience.physics.model.RelativisticModel;
// import org.jscience.physics.amount.Amount;
//
import java.sql.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Arrays;

import java.net.UnknownHostException;
import java.net.URI;
import java.net.URISyntaxException;

import static spark.SparkBase.staticFileLocation;
import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import static spark.Spark.get;

import com.mongodb.*;

import com.heroku.sdk.jdbc.DatabaseUrl;

import static spark.Spark.*;

import com.todoapp.*;

public class Main {

  public static void main(String[] args) throws MongoException, UnknownHostException {
//        MongoClientURI uri = new MongoClientURI(System.getenv("MONGOHQ_URL"));
//        MongoClient mongoClient = new MongoClient(uri);
//        
//        String dbname = uri.getDatabase();
//        
//        //mongoClient.setWriteConcern(WriteConcern.JOURNALED);
//        DB db = mongoClient.getDatabase(dbname);
//        
//        db.authenticate(uri.getUsername(), uri.getPassword());
        
       MongoURI mongoURI = new MongoURI(System.getenv("MONGOHQ_URL"));
        //get connected
        DB db = mongoURI.connectDB();
        // authenticate
        // (version 2.7.2) db.authenticate(mongoURI.getUsername(), mongoURI.getPassword());
        MongoCredential credential = MongoCredential.createCredential(mongoURI.getUsername(), mongoURI.getDatabase(), mongoURI.getPassword());
        MongoClient mongoClient = new MongoClient(new ServerAddress(), Arrays.asList(credential));
        staticFileLocation("/public");
        new TodoResource(new TodoService(db));
        
//        mongoClient.close();
    }
}
