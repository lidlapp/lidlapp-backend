systemctl stop lidlapp
mv target/lidlapp.jar /var/lidlapp-backend/
systemctl start lidlapp
