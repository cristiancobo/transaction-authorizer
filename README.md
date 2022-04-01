# transaction-authorizer

Input account example: POST
http://localhost:8080/api/v1.0/accounts/
_______________________________________________________________
{
    "id":1,
    "activeCard": true,
    "availableLimit": 3000
}

Input transaction example: POST
http://localhost:8080/api/v1.0/transactions/
_______________________________________________________________
{

    "accountId":1,
    "merchant":"Makro",
    "amount":111

}

URis

http://localhost:8080/api/v1.0/accounts/ GET ALL ACCOUNTS
http://localhost:8080/api/v1.0/accounts/id GET ACCOUNT BY ID
http://localhost:8080/api/v1.0/transactions/ GET ALL Transactions
http://localhost:8080/api/v1.0/transactions/id GET transaction by id
