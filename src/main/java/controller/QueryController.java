package controller;

import dbConnection.Connector;
import model.ValidationModel;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryController {
    Connector connector;
    ValidationModel validationModel;

    public QueryController(ValidationModel validationModel) {
        connector = new Connector();
        this.validationModel = validationModel;
    }

    public void SelectQuery(String query){
        try {
            if (validationModel.isValid() == "VALID"){
                Statement statement = connector.getDbConnection().createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                int colCount = resultSetMetaData.getColumnCount();
                while (resultSet.next()) {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i = 1; i <= colCount; i++){
                        stringBuilder.append(resultSet.getString(i));
                        stringBuilder.append(" ");

                    }
                    System.out.println(stringBuilder);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
