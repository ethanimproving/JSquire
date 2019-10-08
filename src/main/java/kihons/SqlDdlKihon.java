package kihons;

import framework.bases.SqlDdlKihonBase;

public class SqlDdlKihon extends SqlDdlKihonBase {
    @Override
    public String createTablePersonWithOneColumn() {

        String ct = "CREATE TABLE Person" +
                     "(" +
                     "PersonId int not null PRIMARY KEY " +
                     ")";

        return ct;
    }
}
