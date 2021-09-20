# estore-evoucher

-----

## Preparation
- Firstly, Create **eStore** database in MySQL
- Run [EstoreEvoucherApplication](https://github.com/wailwinphyo/estore-evoucher/blob/master/src/main/java/com/codetest/estoreevoucher/EstoreEvoucherApplication.java) file in IDE and it will create table automatically
- Import sql databackup from [this Sql file] (https://github.com/wailwinphyo/estore-evoucher/blob/master/resource/database/data.sql)
- Postman collection is [here](https://github.com/wailwinphyo/estore-evoucher/tree/master/resource/postman)

## For Testing APIs
- For Admin API, it need user with **Role_ADMIN** Role.

| UserType        | Sample Json           |
| ------------- |:-------------:|
| Admin         | { "username" : "sam", "password": "12345" } |
| User          | { "username" : "jame", "password": "12345" }|

### Admin Apis
- Get Token by submitting username and password to **Token Authenticate** Api
- Add Token as *Bearer header* when calling **EVoucher - Create** to create EVoucher 
- To Edit existing EVoucher, call **EVoucher - Edit** Api
- To update Evoucher Active status, use **EVoucher - Active Status Update**

### User Apis
- Get Evoucher list by using **EVoucher - list** Api
- Get Evoucher detail by using **Evoucher - Detail** Api which need to pass Evoucher Id in header
- Get Payment methods by using **List Payment Methods**
- Check out EVoucher by using **Evoucher - Check out** Api which need evoucher id and other requirements as form-data
- Get Purchase history by using **Purchase History** Api
- Check promocode by using **Check Promo code** api which need promocode in path variable
