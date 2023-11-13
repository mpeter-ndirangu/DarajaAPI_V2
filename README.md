# DarajaAPI_V2

mvn jasypt:encrypt -Djasypt.encryptor.password=d@1m@S@cc02023# -Djasypt.plugin.path="file:src/main/resources/application-daimaqa.yml"

curl -X POST "http://localhost:8080/api/v1/payment" -H "accept: application/json" -H "Content-Type: application/json" -d "{ \"Amount\": 10, \"CommandID\": \"SalaryPayment\", \"MobileNumber\": 254720752361, \"Narration\": \"Daima DRJ Test LIVE\"}"

curl -X POST "http://localhost:8080/api/v1/payment" -H "accept: application/json" -H "Content-Type: application/json" -d "{ \"Amount\": 10, \"CommandID\": \"SalaryPayment\", \"MobileNumber\": 254724374314, \"Narration\": \"Daima DRJ Test LIVE\"}"


## Create Services
sudo nano /etc/systemd/system/DarajaAPI.service
### Paste the below content to the file:
[Unit]
Description=Mpesa Daraja API Service
After=syslog.target
[Service]
User=ubuntu
Restart=always
RestartSec=30s
ExecStart=/usr/bin/java -jar /home/ubuntu/Documents/applications/Daraja/DarajaAPI.jar SuccessExitStatus=143
[Install]
WantedBy=multi-user.target


## Enable Start Service
sudo systemctl start DarajaAPI.service
sudo systemctl status DarajaAPI.service
sudo systemctl stop DarajaAPI.service
sudo systemctl restart DarajaAPI.service

