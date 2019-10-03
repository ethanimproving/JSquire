package kihons;

import framework.exceptions.NotImplementedYetException;
import framework.bases.SqlKihonBase;

public class SqlKihon extends SqlKihonBase {

    /* Given SQL Tables defined as:
     * ----------------------------
     * CREATE TABLE Person
       (
         PersonId int not null PRIMARY KEY,
         FirstName varchar(50),
         LastName varchar(50),
         Age int
       )
     *
     * CREATE TABLE Address
       (
         AddressId int not null PRIMARY KEY,
         PersonId int,
         Line1 varchar(50),
         Line2 varchar(50),
         City varchar(50),
         State varchar(50),
         Zip varchar(9)
       )
     */

    @Override
    protected String Select_All_Fields_And_Rows_From_Person() {
        return "SELECT * FROM Person";
    }

    @Override
    protected String selectAllFieldsFromPersonJoinedToAddress() {
        return "SELECT * FROM Person AS p, Address AS a WHERE p.PersonId = a.PersonId";
    }

    @Override
    protected String selectFirstNameFromPersonWhereLastNameEqualsRayburn() {
        return "SELECT FirstName FROM Person WHERE LastName = 'Rayburn'";
    }

    @Override
    protected String selectAllFieldsFromPersonLeftOuterJoinedToAddress() {
        return "SELECT * FROM Person AS p LEFT JOIN Address AS a ON p.PersonId = a.PersonId";
    }

    @Override
    protected String insertPersonId4NamedMikeJohnsonAge5ToPerson() {
        return "INSERT INTO Person VALUES (4, 'Mike', 'Johnson', 5)";
    }

    @Override
    protected String updateAllLastNamesRayburnToJohnsonInPerson() {
        return "UPDATE Person SET LastName = 'Johnson' WHERE LastName = 'Rayburn'";
    }
}
