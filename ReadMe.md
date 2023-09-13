In this project, I try to learn the factory desging pattern by doing project.
Suppose, you are resident of dhaka city. You have to pay the various service bill.Such as 
1. Electricity,
2. Water,
3. internet , 
4. gas bill. 
And  it is provided by various operator
Electricity
- DESCO
- DPDC
- PDB
Water
- WASA
Internet
- link3
- BTCL
- AMBER IT
Here, customer put a post request with 
- BillType, 
- BilerOperator, 
- BillId, 
- BillName,
- BillAmount

In this project, i have created service for each of the operator. And all of them implement a interface name 
PaymentService which has four parameter that describes in the above.
Through PaymentFactory we passed our request to the specefic service. If the Payment amount is getter than 500 , 
the BillType is Electricity, billoperator DESCO  then we have seen a message that DPDC payment is success full with my provided 
name.
![billpayment](https://github.com/abid-mugdho9875/BillPayment/assets/75389185/81100a42-6ca0-4672-8031-77bd8e40c8af)


In the code we try to implement the code with a bean type of singlepattern.



