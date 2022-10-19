curl --location --request POST 'http://localhost:7000/order/v1/create' \
--header 'Content-Type: application/json' \
--data-raw '{
    "customer" : {
       "name":"customer created",
       "email": "customer@email.com",
       "phone": "+35560111111",
       "street": "street1",
       "streetAdditional":"street add",
       "zip":"1011",
       "city":"Tirana",
       "country":"AL"},
        "dateInstallation":"2022-10-27",
        "timeInstallation":"15:00",
        "productCategoryIds":[1,4]
}'