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

    public String SelectQuery(String query){
        StringBuilder stringBuilder = new StringBuilder();
        try {
            if (validationModel.isValid() == "VALID"){
                Statement statement = connector.getDbConnection().createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                int colCount = resultSetMetaData.getColumnCount();
                for (int i = 1; i <= colCount; i++){
                    stringBuilder.append(resultSetMetaData.getColumnName(i));
                    stringBuilder.append("\t");
                }
                stringBuilder.append("\n");
                while (resultSet.next()) {

                    for (int i = 1; i <= colCount; i++) {
                        stringBuilder.append(resultSet.getString(i));
                        stringBuilder.append("\t");

                    }
                    stringBuilder.append("\n");
                }

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return stringBuilder.toString();
    }
}
