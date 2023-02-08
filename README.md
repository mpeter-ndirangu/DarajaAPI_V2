# DarajaAPI_V2

mvn jasypt:encrypt -Djasypt.encryptor.password=d@1m@S@cc02023# -Djasypt.plugin.path="file:src/main/resources/application-daimaqa.yml"

curl -X POST "http://localhost:8080/api/v1/payment" -H "accept: application/json" -H "Content-Type: application/json" -d "{ \"Amount\": 10, \"CommandID\": \"SalaryPayment\", \"MobileNumber\": 254720752361, \"Narration\": \"Daima DRJ Test LIVE\"}"

curl -X POST "http://localhost:8080/api/v1/payment" -H "accept: application/json" -H "Content-Type: application/json" -d "{ \"Amount\": 10, \"CommandID\": \"SalaryPayment\", \"MobileNumber\": 254724374314, \"Narration\": \"Daima DRJ Test LIVE\"}"