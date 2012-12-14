# jadaboop

A Clojure library designed to insert data in a database (mysql or postgres) from cascalog.

## Usage

First, comment/uncomment the JDBC related code appropriately in `core.clj` (depending if you want to
use postgres or mysql). Also, change `<username>` and `<password>` according to your setup.

Then, run `lein deps` and create the database and the table. Here is the mysql example:

    mysql -u root
    > create database bld;
    > use bld;
    > create table tweets (id varchar(100), handle varchar(100), tweet varchar(100));
    > quit

Finally, run:

    lein run

This will add data to the `tweets` table.

## License

Copyright © 2012 FIXME

Distributed under the Eclipse Public License, the same as Clojure.
