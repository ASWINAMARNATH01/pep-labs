# Background
SQL sublanguage: DML (Data Manipulation Language)

Now that we know how to insert and remove records from a table, we are going to learn how to update a record.

To update a record we utilize the `UPDATE` keyword. The syntax for updating a record is as follows:
```sql
UPDATE table_name SET col_1 = val_1, col_2 = val_2, ...col_N = val_N WHERE condition;
```

NOTE: The `WHERE` condition is important because if you leave this out, that column will be updated throughout all the records in the table.


Additional Resource if needed: https://www.w3schools.com/sql/sql_update.asp

- - - 

# Lab

## Problem 1
users table:
|   id  |     firstname        |        lastname        |
|-------|----------------------|------------------------|
|1      |'Steve'               |'Garcia'                |
|2      |'Alexa'               |'Smith'                 |
|3      |'Steve'               |'Jones'                 |
|4      |'Brandon'             |'Smith'                 |
|5      |'Adam'                |'Jones'                 |

#### Problem 1: Update Alexa's last name to be 'Rush' in the users table.

- - -

## Problem 2 
users table:
|   id  |     firstname        |        lastname        |
|-------|----------------------|------------------------|
|1      |'Steve'               |'Garcia'                |
|2      |'Alexa'               |'Smith'                 |
|3      |'Steve'               |'Jones'                 |
|4      |'Brandon'             |'Smith'                 |
|5      |'Adam'                |'Jones'                 |

#### Problem 2: Update id 4 to have the firstname 'Chad' and the lastname 'Irving'

- - -

## Problem 3
users table:
|   id  |     firstname        |        lastname        |
|-------|----------------------|------------------------|
|1      |'Steve'               |'Garcia'                |
|2      |'Alexa'               |'Smith'                 |
|3      |'Steve'               |'Jones'                 |
|4      |'Brandon'             |'Smith'                 |
|5      |'Adam'                |'Jones'                 |

#### Problem 3: Update id 1 and 3 to have the firstname 'Steven'

HINT: How would you filter id 1 OR 3?